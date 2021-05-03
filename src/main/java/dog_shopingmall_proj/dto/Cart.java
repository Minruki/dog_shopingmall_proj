package dog_shopingmall_proj.dto;

public class Cart {
	private String image;
	private String kind;
	private int price;
	private int qty;

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(String kind) {
		this.kind = kind;
	}

	public Cart(String image, String kind, int price, int qty) {
		this.image = image;
		this.kind = kind;
		this.price = price;
		this.qty = qty;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (kind == null) {
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Cart [image=%s, kind=%s, price=%s, qty=%s]", image, kind, price, qty);
	}

}
