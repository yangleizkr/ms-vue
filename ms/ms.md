### #ms管理系统

### List 和Set的区别

- List：有序，按对象进入的顺序保存对象，可以重复。因为是有顺序，所以可以使用下标取数据，也可以使用Iterator遍历
- Set：无序，不可重复，因为不可重复，所以最多只能有一个Null对象，因为无序，所以只能使用Iterator遍历，没有下标。

### HashCode与equals

- HashCode，hashCode()的作用是获取哈希码，也叫散列表，返回的结果是一个int整数；这个方法定义在JDK的Object.java中，所以每个Java类都有hashCode()方法，散列表存储的是一个键值对(int，对象的地址)，用于快速的找到对象。
- 如果两个对象相等，则hashCode一定也是相同的
- 两个对象相等，对两个对象分别调用equals方法都返回true
- 两个对象有相同的hashCode值，他们也不一定相等。
- 因此，equals方法被覆盖过，则hashCode也必须被覆盖

### ArrayList与LinkedList

- ArrayList基于动态数组，数据扩容
- LinkedList基于链表，维护了Node内部类，维护对象的前后节点的指针
- 通常情况下ArrayList查询效率比较高，LinkedList更新插入效率比较高
- 特殊情况下，ArrayList在顺序插入时，插入数据的效率甚至比LinkedList好

### Spring是什么

- 轻量级容器框架，用来装JavaBean的，中间层框架，主要功能 IOC，AOP。
- IOC降低代码的耦合性，常见分层控制。
- AOP降低代码的重复性，例如日志打印，权限控制等公共处理代码

### IOC理解

- 容器概念、控制反转、依赖注入
- IOC容器：实际上就是一个map，在项目启动的时候，Spring会自动扫描所有添加注解的类，在IOC容器中维护起来。
- 控制反转：创建对象的操作不通过用户，而是交给IOC容器管理
- 依赖注入：是实现控制反转的一个方法。

### AOP理解

- 处理交叉业务逻辑：常见业务场景，事务处理，异常处理，日志打印，权限控制
- 添加注解，可增强接口的功能性。

### BeanFactory和ApplicationContext有什么区别

- ApplicationContext是BeanFactory的子接口
- ApplicationContext提供了更完整的功能

