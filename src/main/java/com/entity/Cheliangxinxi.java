package com.entity;

public class Cheliangxinxi {
    private Integer id;
	private String chepaihao;	private String cheliangpinpai;	private String chexing;	private String zhuangtai;	private String tupian;	private String beizhu;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getChepaihao() {
        return chepaihao;
    }
    public void setChepaihao(String chepaihao) {
        this.chepaihao = chepaihao == null ? null : chepaihao.trim();
    }	public String getCheliangpinpai() {
        return cheliangpinpai;
    }
    public void setCheliangpinpai(String cheliangpinpai) {
        this.cheliangpinpai = cheliangpinpai == null ? null : cheliangpinpai.trim();
    }	public String getChexing() {
        return chexing;
    }
    public void setChexing(String chexing) {
        this.chexing = chexing == null ? null : chexing.trim();
    }	public String getZhuangtai() {
        return zhuangtai;
    }
    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai == null ? null : zhuangtai.trim();
    }	public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
        this.tupian = tupian == null ? null : tupian.trim();
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
