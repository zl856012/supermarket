package order;

import java.util.Scanner;

import pojo.OrderItem;

public class Test {
	
 public static void main(String[] args) {
	 
	 OrderServiceImpl order = new OrderServiceImpl();
	 //初始化数据
	 OrderItem item1 =new OrderItem(1l, 1l, "苹果", 8.0, 100, 0, 100l, 10l);
	 OrderItem item2 =new OrderItem(2l, 2l, "草莓", 13.0, 100, 0, 100l, 10l);
	 order.addItem(item1);
	 order.addItem(item2);
	 
	 Scanner scanner= new Scanner(System.in);
	 Boolean loop = true;
	 while (loop) {
		System.out.println("超市商品 1、新增商品 2、销售商品 3、修改折扣 4、满减销售  5、订单支付6、退出\n");
		Integer num = scanner.nextInt();
		switch (num) {
		case 1:
			order.addGoods();
			break;
		case 2:
			order.order();
			order.orderList();
			order.calculateTotalPrice();
			break;
		case 3:
			order.updateDiscount();
			break;
		case 4:
			order.order();
			order.calculateTotalPrice();
			order.orderList();
			order.shoppingOver();
			break;
		case 5:
			order.orderPay();
			break;
		case 6:
			System.out.println("确认退出y/n");
			String transok = scanner.next();
			if ("y".equals(transok)) {
				System.out.println("退出成功");
				loop = false;
			}
			break;
		default:
			System.out.println("请输入编号：");
			break;
		}
		
	}
}
 
}
