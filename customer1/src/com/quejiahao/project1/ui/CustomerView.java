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
            System.out.println("\n-----------------�ͻ���Ϣ�������-----------------\n");
            System.out.println("                   1 �� �� �� ��");
            System.out.println("                   2 �� �� �� ��");
            System.out.println("                   3 ɾ �� �� ��");
            System.out.println("                   4 �� �� �� ��");
            System.out.println("                   5 ��       ��\n");
            System.out.print("                   ��ѡ��(1-5)��");

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

                    System.out.println("----------------�͑��б�----------------");

                        listAllCustomers();

                    break;
                case '5':
                    System.out.println("�Ƿ��˳���y/n��");
                    char isexit=CMUtility.readConfirmSelection();
                    if(isexit=='Y'){
                        isfalg=false;
                    }
                    break;

            }


        }while (isfalg);

    }
    private void addNewCustomer(){
        System.out.println("---------����û�---------");
        System.out.println("---------�����û�������---------");
        String name=CMUtility.readString(20);
        System.out.println("---------�����û��Ա�---------");
        char gender=CMUtility.readChar();
        System.out.println("---------�����û����䣺---------");
        int age=CMUtility.readInt();
        System.out.println("---------�����û��ֻ���---------");
        String phone=CMUtility.readString(11);
        System.out.println("---------�����û����䣺---------");
        String email=CMUtility.readString(20);

        Customer cust=new Customer(name,gender,age,phone,email);
        boolean issucess=customerList.addCustomer(cust);
        if(issucess){
            System.out.println("����û��ɹ�");
        }else {
            System.out.println("����û�ʧ��");
        }

    }
    private void modifyCustomer(){
        System.out.println("-----------�޸��û�-----------");
        int number;
        for(;;) {
            System.out.println("ѡ���޸���һ���û���-1�˳�����");
            number = CMUtility.readInt();
            if(number==-1){
                return;
            }else {
                break;
            }
        }
        Customer customer=customerList.getCustomer(number-1);
        if(customer!=null){
            System.out.println("---------����������---------"+customer.getName());
            String name=CMUtility.readString(10,customer.getName());
            System.out.println("---------�����Ա�---------"+customer.getGender());
            char gender=CMUtility.readChar(customer.getGender());
            System.out.println("---------�������䣺---------"+customer.getAge());
            int age=CMUtility.readInt(customer.getAge());
            System.out.println("---------�����ֻ���---------"+customer.getPhone());
            String phone=CMUtility.readString(11,customer.getPhone());
            System.out.println("---------�������䣺---------"+customer.getEmail());
            String email=CMUtility.readString(20,customer.getEmail());
            Customer cust=new Customer(name,gender,age,phone,email);
            customerList.replaceCustomer(number-1,cust);
            System.out.println("�޸ĳɹ�");
        }else {
            System.out.println("�޸�ʧ��");
            return;
        }

    }
    private void deleteCustomer(){
        System.out.println("----------ɾ���û�----------");
        int number;
        char delete;
        for(;;){
            System.out.println("��ѡ��ɾ�����û����:");
             number=CMUtility.readInt();
             Customer isture=customerList.getCustomer(number-1);
             if(isture!=null){
                 System.out.println("�Ƿ�ɾ������y/n��"+isture.getName());
                  delete=CMUtility.readConfirmSelection();
                 if(delete=='Y'){
                     customerList.deleteCustomer(number-1);
                     System.out.println("ɾ���ɹ�");
                     return;
                 }
                 else {
                     System.out.println("�˳�ɾ��");
                     return;
                 }
             }else {
                 System.out.println("�޴��û�");
                 break;
             }
        }

    }
    private void listAllCustomers(){
        Customer[] customer = customerList.getAllCustomers();
        int total=customerList.getTotal();
        if(total==0){
            System.out.println("�o�͑���Ϣ!!!!!");
        }else {
            System.out.println("��̖\t\t����\t�Ա�\t\t����\t\t�绰\t\t\t����");
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
