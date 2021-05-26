package com.yl.ms.test;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author yl on 2021/5/21
 */
public class XmlProcessor {


    private Connection connection = null;

    /**
     * Get Db Connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void openMysqlConnection() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/stackoverflow";
        String username = "root";
        String password = "123456";
        Connection connection = null;

        Class.forName(driver);
        connection = DriverManager.getConnection(url, username, password);
        this.connection = connection;
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }

    /**
     *
     * @param filePath
     * @param commitCount 行提交一次
     * @throws SQLException
     * @throws FileNotFoundException
     * @throws XMLStreamException
     */
    public void parsePosts(String filePath, int commitCount) throws SQLException, FileNotFoundException, XMLStreamException {
        // 计时器 starts
        Long begin = new Date().getTime();

        // 组合sql语句
        String prefixQuestions = "INSERT INTO questions VALUES ";
        String prefixAnswers = "INSERT INTO answers VALUES ";
        StringBuffer suffixQuestions = new StringBuffer();
        StringBuffer suffixAnswers = new StringBuffer();
        // 设置事务为非自动提交
        this.connection.setAutoCommit(false);
        // PreparedStatement 执行 sql语句
        PreparedStatement pst = (PreparedStatement) this.connection.prepareStatement("");

        // 解析xml获得数据
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        inputFactory.setProperty("http://www.oracle.com/xml/jaxp/properties/getEntityCountInfo", "yes");
        // 设置entity size , 否则会报 JAXP00010004 错误
        inputFactory.setProperty("http://www.oracle.com/xml/jaxp/properties/totalEntitySizeLimit", Integer.MAX_VALUE);
        File file = new File(filePath);

        InputStream isS= new FileInputStream(file);
        XMLStreamReader streamReader = inputFactory.createXMLStreamReader(isS);

        int countRow = 0;
        // Q: Id CreationDate Score ViewCount OwnerUserId Tags AnswerCount FavoriteCount
        // A: Id ParentId CreationDate Score CommentCount
        String id, creationDate, score, viewCount, ownerUserId, tags, answerCount, favoriteCount, parentId, commentCount;
        String postTypeId;
        String sqlQuestions = null, sqlAnswers = null;
        // 存储数据
        while(streamReader.hasNext()) {
            streamReader.next();
            if(streamReader.getEventType() == XMLStreamReader.START_ELEMENT){
                if (streamReader.getLocalName().equals("row")) {

                    postTypeId = streamReader.getAttributeValue(null,"PostTypeId");
                    id = streamReader.getAttributeValue(null,"Id");
                    creationDate = streamReader.getAttributeValue(null,"CreationDate");
                    score = streamReader.getAttributeValue(null,"Score");
                    viewCount = streamReader.getAttributeValue(null,"ViewCount");
                    ownerUserId = streamReader.getAttributeValue(null,"OwnerUserId");
                    tags = streamReader.getAttributeValue(null,"Tags");
                    answerCount = streamReader.getAttributeValue(null,"AnswerCount");
                    favoriteCount = streamReader.getAttributeValue(null,"FavoriteCount");
                    parentId = streamReader.getAttributeValue(null,"ParentId");
                    commentCount = streamReader.getAttributeValue(null,"CommentCount");

                    // 1 Question, 2 Answer
                    if ("1".equals(postTypeId)) {
                        suffixQuestions.append("(" + id + "," +  "\"" + creationDate + "\"" + ","  +
                                score  + "," + viewCount + "," + ownerUserId + ","  +
                                "\"" + tags + "\"" + "," + answerCount + "," + favoriteCount + "),");
                    } else {
                        suffixAnswers.append("(" + id + "," + parentId + "," + "\"" + creationDate + "\"" + ","  +
                                score  + "," + ownerUserId + "," + commentCount + "),");
                    }
                    countRow += 1; // 记录行数

                    if (countRow % commitCount == 0) {
                        // System.out.print("Count: " + Integer.toString(count));

                        // 构建完整sql
                        sqlQuestions = prefixQuestions + suffixQuestions.substring(0, suffixQuestions.length() - 1);
                        sqlAnswers = prefixAnswers + suffixAnswers.substring(0, suffixAnswers.length() - 1);
                        // 添加执行sql
                        pst.addBatch(sqlQuestions);
                        pst.addBatch(sqlAnswers);
                        // 执行操作
                        pst.executeBatch();
                        // 提交事务
                        this.connection.commit();
                        // 清空上一次添加的数据
                        suffixQuestions = new StringBuffer();
                        suffixAnswers = new StringBuffer();
                        System.out.println("Committed: " + countRow + " √");
                    }
                }
            }
        }

        if (suffixQuestions.length() != 0) {
            sqlQuestions = prefixQuestions + suffixQuestions.substring(0, suffixQuestions.length() - 1);
            pst.addBatch(sqlQuestions);
            pst.executeBatch();
            connection.commit();
        }
        if (suffixAnswers.length() != 0) {
            sqlAnswers = prefixAnswers + suffixAnswers.substring(0, suffixAnswers.length() - 1);
            // System.out.println(suffixAnswers.substring(0, suffixAnswers.length() - 1));
            pst.addBatch(sqlAnswers);
            pst.executeBatch();
            connection.commit();
        }
        System.out.println("Committed All: " + countRow + " √");
        pst.close();

        // 耗时
        Long end = new Date().getTime();
        System.out.println("Cast : " + (end - begin) / 1000 + " s");
    }

}
