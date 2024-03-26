package order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.jws.soap.SOAPBinding;

import pojo.OrderItem;

public class OrderServiceImpl {

	ArrayList<OrderItem> orderItems= new ArrayList<OrderItem>();
	Scanner scanner=new Scanner(System.in);
	double totalPrice = 0.0;
	
	public void addGoods() {
		System.out.println("请输入单号\n");
		Long orderId =scanner.nextLong() ;
		
		System.out.println("请输入商品ID\n");
		Long goodsId = scanner.nextLong();
		
		System.out.println("请输入商品名称\n");
		String title = scanner.next();
		
		System.out.println("请输入商品价格\n");
		Integer price = scanner.nextInt();
		
		System.out.println("请输入商品折扣\n");
		Integer discount = scanner.nextInt(); //折扣，以整数表示，如95折
		
		System.out.println("请输入商品数量\n");
		Integer num = scanner.nextInt();		
		
		System.out.println("请输入满减总数\n");
		Long totalAbove = scanner.nextLong();	
		
		System.out.println("请输入满减额度\n");
		Long totalDeduct = scanner.nextLong();
		
		OrderItem orderItem=new OrderItem(orderId, goodsId, title, price, discount, num, totalAbove, totalDeduct);
		
	    orderItems.add(orderItem);
	    System.out.println("添加成功");
	}
	
	//销售商品
	public void order() {
		System.out.println("请输入要购买的商品编号");
		
		Long goodsId = scanner.nextLong();	
		
		System.out.println("请输入要购买的商品数量");
		
		Integer num = scanner.nextInt();	
		
		for (OrderItem item : orderItems) {
			if (item.getGoodsId().equals(goodsId)) {
				item.setNum(num);

			} else {
			}
			
		}

	}
	
	//修改折扣
	public void updateDiscount() {
		System.out.println("请输入要修改折扣的商品编号");
		
		Long goodsId = scanner.nextLong();	
		
		System.out.println("请输入要修改的折扣");
		
		Integer discount = scanner.nextInt();	
		
		for (OrderItem item : orderItems) {
			if (item.getGoodsId().equals(goodsId)) {
				item.setDiscount(discount);

			} else {

			}			
		}

	}
	
	//商品明细
	public void orderList() {
        for (OrderItem item : orderItems) {
        	if(!(item.getNum()==0)) {
        		System.out.println(item.getTitle()+"数量:"+item.getNum()+"----"+"该商品总价格："+item.calculatePrice());
        	}
    		
        }

	}
	
	//购物满 100 减 10 块
	public void shoppingOver() {
		double totalPrice = calculateTotalPrice();
		if (totalPrice>100) {			
			int temp = (int) (totalPrice/100);
			totalPrice = totalPrice-(temp*10);
		}
		System.out.println("\n商品活动总价格："+totalPrice);
	}
	
    // 向订单中添加商品
    public void addItem(OrderItem item) {
    	orderItems.add(item);
    }

    // 计算订单的总价
    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (OrderItem item : orderItems) {
            totalPrice += item.calculatePrice();
        }
		System.out.println("\n商品总价格："+totalPrice);
        return totalPrice;
    }

	//支付
	public void orderPay() {

        for (OrderItem item : orderItems) {
            item.setNum(0);;
        }
		System.out.println("订单已经支付");
	}
	
}
