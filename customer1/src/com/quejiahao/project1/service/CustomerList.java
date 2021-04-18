package com.quejiahao.project1.service;

import com.quejiahao.project1.bean.Customer;

/**
 * @description:
 * @author:
 * @date: 2021/4/7 15:04
 * @version:1.0
 */

public class CustomerList {
    private Customer[] customers;
    private int total=0;



    public CustomerList(int totalCustomer){
        customers=new Customer[totalCustomer];
    }

    /**
     * @description: 给数组添加一个客户数据类型
     * @param
     */
    public boolean addCustomer(Customer customer){

        if(total>=customers.length){
            return false;
        }

            customers[total++]=customer;
            return true;

    }

    /**
     * 修改具体索引上的客户信息
     * @param index
     * @param cust
     * @return
     */

    public boolean replaceCustomer(int index, Customer cust){

        if(index>=total||index<0){
            return false;
        }else {
                customers[index]=cust;
                return true;
        }
    }

    /**
     * 删除索引位置上的
     * @param index
     * @return
     */
    public boolean deleteCustomer(int index){

        if(index>=total||index<0){
            return false;
        }else {
            for (int i = index; i < total - 1; i++) {
                customers[i] = customers[i + 1];
            }
            customers[total-1]=null;
            total--;
            return true;
        }
    }

    /**
     * 获得所有客户信息
     * @return
     */

    public Customer[] getAllCustomers(){
        Customer[] c1=new Customer[total];
        for(int i=0;i<total;i++){
            c1[i]=customers[i];
        }
        return c1;
    }

    /**
     * 获取索引位置上的客户信息
     * @param index
     * @return
     */
    public Customer getCustomer(int index){
        if(index>=total||index<0){
            return null;
        }
        else {
            return customers[index];
        }
    }

    /**
     * 获取客户的总量
     * @return
     */
    public int getTotal(){
        int t=total;
        return t;
    }




}
