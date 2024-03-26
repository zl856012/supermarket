package pojo;

import java.math.BigDecimal;

/**
 * 订单
 * @author zzl
 * 
 *
 */
public class OrderItem {
	
	private Long orderId;
	
	private Long goodsId;
	
	private String title;
	
	private double price;
	
	private Integer discount =1 ; //折扣，以整数表示，如95折
	
	private Integer num;
	
	private double totalFee;
	
	private Long totalAbove;	
	
	private Long totalDeduct;	
	
	private String sellerId;

	public OrderItem(Long orderId, Long goodsId, String title, double price, Integer discount, Integer num, 
			Long totalAbove, 
			Long totalDeduct

			) {
		super();
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.title = title;
		this.price = price;
		this.discount = discount;
		this.num = num;
		this.totalAbove = totalAbove;
		this.totalDeduct = totalDeduct;

	}

    // 计算商品的总价
    public double calculatePrice() {
        return price * num * discount/100;
    }


	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	public Long getTotalAbove() {
		return totalAbove;
	}

	public void setTotalAbove(Long totalAbove) {
		this.totalAbove = totalAbove;
	}

	public Long getTotalDeduct() {
		return totalDeduct;
	}

	public void setTotalDeduct(Long totalDeduct) {
		this.totalDeduct = totalDeduct;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}


		


}
