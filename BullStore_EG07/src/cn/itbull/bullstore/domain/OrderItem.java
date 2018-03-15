package cn.itbull.bullstore.domain;
/**
 * 订单项类
 */
public class OrderItem {
	// 订单项的id
	private Integer id;

	// 商品的名称
	private String name;

	// 商品的单价
	private double price;

	// 订单项中商品的数量
	private int count;

	// 订单项中商品的金额
	private double money;

	// 商品的地址
	private String address;

	// 商品图片的地址
	private String imagePath = "/static/img/default.jpg";

	// 订单项所属的订单号
	private String orderId;

	public OrderItem() {
		super();

	}

	public OrderItem(Integer id, String name, double price, int count, double money, String address, String imagePath,
			String orderId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
		this.money = money;
		this.address = address;
		this.imagePath = imagePath;
		this.orderId = orderId;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", name=" + name + ", price=" + price + ", count=" + count + ", money=" + money
				+ ", address=" + address + ", imagePath=" + imagePath + ", orderId=" + orderId + "]";
	}
}
