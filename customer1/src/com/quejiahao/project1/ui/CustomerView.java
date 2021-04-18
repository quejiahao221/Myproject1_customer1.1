package com.quejiahao.project1.ui;

import com.quejiahao.project1.bean.Customer;
import com.quejiahao.project1.service.CustomerList;
import com.quejiahao.project1.util.CMUtility;

/**
 * @description:
 * @author:
 * @date: 2021/4/7 17:18
 * @version:1.0
 */

public class CustomerView {
    private CustomerList customerList=new CustomerList(10);

    public  CustomerView(){
        Customer customer=new Customer("quejiahao",'m',12,"123456789123","qjh@163.com");
        customerList.addCustomer(customer);
    }

    public void enterMainMenu(){
        boolean isfalg=true;
        do {
            System.out.println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char key=CMUtility.readMenuSelection();
            switch (key) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':

                    System.out.println("----------------客戶列表----------------");

                        listAllCustomers();

                    break;
                case '5':
                    System.out.println("是否退出（y/n）");
                    char isexit=CMUtility.readConfirmSelection();
                    if(isexit=='Y'){
                        isfalg=false;
                    }
                    break;

            }


        }while (isfalg);

    }
    private void addNewCustomer(){
        System.out.println("---------添加用户---------");
        System.out.println("---------输入用户姓名：---------");
        String name=CMUtility.readString(20);
        System.out.println("---------输入用户性别：---------");
        char gender=CMUtility.readChar();
        System.out.println("---------输入用户年龄：---------");
        int age=CMUtility.readInt();
        System.out.println("---------输入用户手机：---------");
        String phone=CMUtility.readString(11);
        System.out.println("---------输入用户邮箱：---------");
        String email=CMUtility.readString(20);

        Customer cust=new Customer(name,gender,age,phone,email);
        boolean issucess=customerList.addCustomer(cust);
        if(issucess){
            System.out.println("添加用户成功");
        }else {
            System.out.println("添加用户失败");
        }

    }
    private void modifyCustomer(){
        System.out.println("-----------修改用户-----------");
        int number;
        for(;;) {
            System.out.println("选择修改哪一个用户（-1退出）：");
            number = CMUtility.readInt();
            if(number==-1){
                return;
            }else {
                break;
            }
        }
        Customer customer=customerList.getCustomer(number-1);
        if(customer!=null){
            System.out.println("---------输入姓名：---------"+customer.getName());
            String name=CMUtility.readString(10,customer.getName());
            System.out.println("---------输入性别：---------"+customer.getGender());
            char gender=CMUtility.readChar(customer.getGender());
            System.out.println("---------输入年龄：---------"+customer.getAge());
            int age=CMUtility.readInt(customer.getAge());
            System.out.println("---------输入手机：---------"+customer.getPhone());
            String phone=CMUtility.readString(11,customer.getPhone());
            System.out.println("---------输入邮箱：---------"+customer.getEmail());
            String email=CMUtility.readString(20,customer.getEmail());
            Customer cust=new Customer(name,gender,age,phone,email);
            customerList.replaceCustomer(number-1,cust);
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
            return;
        }

    }
    private void deleteCustomer(){
        System.out.println("----------删除用户----------");
        int number;
        char delete;
        for(;;){
            System.out.println("请选择删除的用户编号:");
             number=CMUtility.readInt();
             Customer isture=customerList.getCustomer(number-1);
             if(isture!=null){
                 System.out.println("是否删除：（y/n）"+isture.getName());
                  delete=CMUtility.readConfirmSelection();
                 if(delete=='Y'){
                     customerList.deleteCustomer(number-1);
                     System.out.println("删除成功");
                     return;
                 }
                 else {
                     System.out.println("退出删除");
                     return;
                 }
             }else {
                 System.out.println("无此用户");
                 break;
             }
        }

    }
    private void listAllCustomers(){
        Customer[] customer = customerList.getAllCustomers();
        int total=customerList.getTotal();
        if(total==0){
            System.out.println("無客戶信息!!!!!");
        }else {
            System.out.println("編號\t\t姓名\t性别\t\t年龄\t\t电话\t\t\t邮箱");
            for (int i = 0; i < total;i++){
                System.out.println((i+1)+"\t"+customer[i].getName()+"\t"+customer[i].getGender()+"\t"+customer[i].getAge()+"\t"+customer[i].getPhone()+"\t"+customer[i].getEmail());
            }

        }
    }

    public static void main(String[] args) {
        CustomerView customerView=new CustomerView();
        customerView.enterMainMenu();
    }
}
