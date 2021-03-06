package com.crm.pojo;

import java.util.Date;

public class CustomerContact {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact.id
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact.cus_id
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    private Integer cusId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact.contact_time
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    private Date contactTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact.address
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact.overview
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    private String overview;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact.id
     *
     * @return the value of customer_contact.id
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact.id
     *
     * @param id the value for customer_contact.id
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact.cus_id
     *
     * @return the value of customer_contact.cus_id
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public Integer getCusId() {
        return cusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact.cus_id
     *
     * @param cusId the value for customer_contact.cus_id
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact.contact_time
     *
     * @return the value of customer_contact.contact_time
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public Date getContactTime() {
        return contactTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact.contact_time
     *
     * @param contactTime the value for customer_contact.contact_time
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public void setContactTime(Date contactTime) {
        this.contactTime = contactTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact.address
     *
     * @return the value of customer_contact.address
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact.address
     *
     * @param address the value for customer_contact.address
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact.overview
     *
     * @return the value of customer_contact.overview
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public String getOverview() {
        return overview;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact.overview
     *
     * @param overview the value for customer_contact.overview
     *
     * @mbggenerated Thu Oct 26 15:00:41 CST 2017
     */
    public void setOverview(String overview) {
        this.overview = overview == null ? null : overview.trim();
    }
}