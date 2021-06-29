package com.entity;

public class Huowuxinxi {
    private Integer id;
	private String huowubianhao;	private String huowumingcheng;	private String huowuleixing;	private String kucun;	private String jiage;	private String shiwutu;	private String beizhu;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getHuowubianhao() {
        return huowubianhao;
    }
    public void setHuowubianhao(String huowubianhao) {
        this.huowubianhao = huowubianhao == null ? null : huowubianhao.trim();
    }	public String getHuowumingcheng() {
        return huowumingcheng;
    }
    public void setHuowumingcheng(String huowumingcheng) {
        this.huowumingcheng = huowumingcheng == null ? null : huowumingcheng.trim();
    }	public String getHuowuleixing() {
        return huowuleixing;
    }
    public void setHuowuleixing(String huowuleixing) {
        this.huowuleixing = huowuleixing == null ? null : huowuleixing.trim();
    }	public String getKucun() {
        return kucun;
    }
    public void setKucun(String kucun) {
        this.kucun = kucun == null ? null : kucun.trim();
    }	public String getJiage() {
        return jiage;
    }
    public void setJiage(String jiage) {
        this.jiage = jiage == null ? null : jiage.trim();
    }	public String getShiwutu() {
        return shiwutu;
    }
    public void setShiwutu(String shiwutu) {
        this.shiwutu = shiwutu == null ? null : shiwutu.trim();
    }	public String getBeizhu() {
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
