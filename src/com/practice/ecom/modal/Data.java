
package com.practice.ecom.modal;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("advance_paid")
    @Expose
    private Double advancePaid;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("conversion_rate")
    @Expose
    private Double conversionRate;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("customer")
    @Expose
    private String customer;
    @SerializedName("customer_group")
    @Expose
    private String customerGroup;
    @SerializedName("customer_name")
    @Expose
    private String customerName;
    @SerializedName("delivery_date")
    @Expose
    private String deliveryDate;
    @SerializedName("doctype")
    @Expose
    private String doctype;
    @SerializedName("base_grand_total")
    @Expose
    private Double baseGrandTotal;
    @SerializedName("grand_total")
    @Expose
    private Double grandTotal;
    @SerializedName("naming_series")
    @Expose
    private String namingSeries;
    @SerializedName("order_type")
    @Expose
    private String orderType;
    @SerializedName("plc_conversion_rate")
    @Expose
    private Double plcConversionRate;
    @SerializedName("price_list_currency")
    @Expose
    private String priceListCurrency;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("selling_price_list")
    @Expose
    private String sellingPriceList;
    @SerializedName("territory")
    @Expose
    private String territory;
    @SerializedName("transaction_date")
    @Expose
    private String transactionDate;
    @SerializedName("cust_address")
    @Expose
    private String custAddress;

    public Double getAdvancePaid() {
        return advancePaid;
    }

    public void setAdvancePaid(Double advancePaid) {
        this.advancePaid = advancePaid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(String customerGroup) {
        this.customerGroup = customerGroup;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    public Double getBaseGrandTotal() {
        return baseGrandTotal;
    }

    public void setBaseGrandTotal(Double baseGrandTotal) {
        this.baseGrandTotal = baseGrandTotal;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getNamingSeries() {
        return namingSeries;
    }

    public void setNamingSeries(String namingSeries) {
        this.namingSeries = namingSeries;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Double getPlcConversionRate() {
        return plcConversionRate;
    }

    public void setPlcConversionRate(Double plcConversionRate) {
        this.plcConversionRate = plcConversionRate;
    }

    public String getPriceListCurrency() {
        return priceListCurrency;
    }

    public void setPriceListCurrency(String priceListCurrency) {
        this.priceListCurrency = priceListCurrency;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getSellingPriceList() {
        return sellingPriceList;
    }

    public void setSellingPriceList(String sellingPriceList) {
        this.sellingPriceList = sellingPriceList;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

}
