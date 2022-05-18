package com.neusoft.elm;

import com.neusoft.elm.po.Admin;
import com.neusoft.elm.view.AdminView;
import com.neusoft.elm.view.BusinessView;
import com.neusoft.elm.view.impl.AdminViewImpl;
import com.neusoft.elm.view.impl.BusinessViewImpl;

import java.util.Scanner;

public class ElmAdminEntry {
    public void work() {
        Scanner input = new Scanner(System.in);
        AdminView adminView=new AdminViewImpl();
        BusinessView businessView = new BusinessViewImpl();
        Admin admin =adminView.login();
        if (admin!=null) {
            System.out.println("登录成功！");
            int menu = 0;
            while (menu != 7) {
                System.out.println("------------------------------------------------------");
                System.out.println("\t\t\t\t\t饿了么后台管理系统");
                System.out.println("------------------------------------------------------");
                System.out.println("\t\t\t\t1.所有商家列表;");
                System.out.println("\t\t\t\t2.搜索商家;");
                System.out.println("\t\t\t\t3.新建商家;");
                System.out.println("\t\t\t\t4.删除商家;");
                System.out.println("\t\t\t\t5.排序;");
                System.out.println("\t\t\t\t6.查询商家;");
                System.out.println("\t\t\t\t7.退出系统;");
                System.out.print("\t请输入您的选择：");
                menu = input.nextInt();
                switch (menu) {
                    case 1:
                        businessView.listBusinessAll();
                        break;
                    case 2:
                        businessView.listBusiness();
                        break;
                    case 3:
                        businessView.saveBusiness();
                        break;
                    case 4:
                        businessView.removeBusiness();
                        break;
                    case 5:
                        System.out.println("请选择通过配送费还是起送费进行排序(配送费为1，起送费为0):");
                        int a1=0,a2=0;
                        a1=input.nextInt();
                        System.out.println("请选择排列方式(升序为0，降序为1)：");
                        a2=input.nextInt();
                        if(a1==0){
                            if(a2==0) {
                                businessView.showStarPrice();
                            }else if(a2==1){
                                businessView.showStarPrice2();
                            }else{
                                System.out.println("您输入的序号有误，请重新输入！");
                            }
                        }else if(a1==1){
                            if(a2==0){
                                businessView.showDeliveryPrice();
                            }else if(a2==1){
                                businessView.showDeliveryPrice2();
                            }else{
                                System.out.println("您输入的序号有误，请重新输入！");
                            }
                        }
                        else{
                            System.out.println("您输入的序号有误，请重新输入！");
                        }
                        break;
                    case 6:
                        System.out.println("请选择通过配送费还是起送费进行查询(配送费为1，起送费为0):");
                        int b1=0;
                        b1=input.nextInt();
                        if(b1==0){
                            businessView.checkStarPrice();
                        }else if(b1==1){
                            businessView.checkDeliveryPrice();
                        }
                        else{
                            System.out.println("您输入的序号有误，请重新输入！");
                        }
                        break;
                    case 7:
                        System.out.println("尊敬的管理员，您已退出系统。");
                        System.out.println("欢迎您下次使用饿了么后台管理系统！");
                        System.out.println("----------------------------------------------------------------\n");
                        break;
                    default:
                        System.out.println("没有这个选项，请您重新输入！");
                        break;

                }
            }
        } else {
            System.out.println("\n管理员名称或密码输入错误，请您重新输入！");
        }
    }
    public static void main(String[] args) {
        new ElmAdminEntry().work();
    }
}



