package org.pogo.entity;

public class BCABadge extends BadgeBase {

	private String city;
	private Integer count;
	private Integer id;
	
	public BCABadge(String city, Integer episode, Integer count, Integer id) {
		this.setEpisode(episode);
		this.setCity(city);
		this.setCount(count);
		this.setId(id);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String title = "tpbigcityadventuregame" + (this.getEpisode()-1);
		StringBuffer sb = new StringBuffer();
		sb.append(title).append(".description=").append(this.getCity()).append(" ")
		.append(this.getCount()).append(" ").append("Badge")
		.append("\n")
		.append(title).append(".description.short=").append(this.getCity()).append(" ").append(this.getCount())
		.append("\n")
		.append(title).append(".game=tpbigcityadventure")
		.append("\n")
		.append(title).append(".info=Complete ").append(this.getCity()).append(" ").append(this.getCount())
		.append("\n")
		.append(title).append(".id=").append(this.getId())
		.append("\n")
		.append(title).append(".category=game")
		.append("\n")
		.append(title).append(".order=").append((this.getEpisode()+"0"));
		return sb.toString();
	}

	
}
