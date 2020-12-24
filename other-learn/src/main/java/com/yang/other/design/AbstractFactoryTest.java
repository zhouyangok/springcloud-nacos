package com.yang.other.design;

/**
 * @ClassName AbatractFactoryTest
 * @Description: 抽象工厂模式
 * @Author zhouyang
 * @Date 2020/12/24 下午9:38.
 */

public class AbstractFactoryTest {

    public static void main(String[] args) {
//        IDataUtils application = new MySqlDataUtils();
        IDataUtils application = new OracleDataUtils();
        IConnection connection = application.getConnection();
        connection.getConnection();
        ICommand command =application.getCommand();
        command.getCommand();
    }

}

interface IConnection {
    void getConnection();
}

class MysqlConnection implements IConnection {
    @Override
    public void getConnection() {
        System.out.println("mysql建立连接了...");
    }
}

class OracleConnection implements IConnection {

    @Override
    public void getConnection() {
        System.out.println("oracle建立连接了...");
    }
}

interface ICommand {
    void getCommand();
}

class MysqlCommand implements ICommand {
    @Override
    public void getCommand() {
        System.out.println("mysql发送命令了...");
    }
}

class OracleCommand implements ICommand {

    @Override
    public void getCommand() {
        System.out.println("oracle发送命令了");
    }
}

interface IDataUtils {
    IConnection getConnection();

    ICommand getCommand();
}

class MySqlDataUtils implements IDataUtils {

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}

class OracleDataUtils implements IDataUtils {

    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}
