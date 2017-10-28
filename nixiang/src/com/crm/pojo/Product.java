package com.crm.pojo;

public class Product {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.id
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_name
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    private String productName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.model
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    private String model;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.unit
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    private String unit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.price
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    private Float price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.store
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    private Double store;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.remark
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.id
     *
     * @return the value of product.id
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.id
     *
     * @param id the value for product.id
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_name
     *
     * @return the value of product.product_name
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_name
     *
     * @param productName the value for product.product_name
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.model
     *
     * @return the value of product.model
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public String getModel() {
        return model;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.model
     *
     * @param model the value for product.model
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.unit
     *
     * @return the value of product.unit
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.unit
     *
     * @param unit the value for product.unit
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.price
     *
     * @return the value of product.price
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public Float getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.price
     *
     * @param price the value for product.price
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.store
     *
     * @return the value of product.store
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public Double getStore() {
        return store;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.store
     *
     * @param store the value for product.store
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public void setStore(Double store) {
        this.store = store;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.remark
     *
     * @return the value of product.remark
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.remark
     *
     * @param remark the value for product.remark
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}