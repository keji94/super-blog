package com.keji.blog.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogPictureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogPictureExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPictureIdIsNull() {
            addCriterion("picture_id is null");
            return (Criteria) this;
        }

        public Criteria andPictureIdIsNotNull() {
            addCriterion("picture_id is not null");
            return (Criteria) this;
        }

        public Criteria andPictureIdEqualTo(Long value) {
            addCriterion("picture_id =", value, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdNotEqualTo(Long value) {
            addCriterion("picture_id <>", value, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdGreaterThan(Long value) {
            addCriterion("picture_id >", value, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdGreaterThanOrEqualTo(Long value) {
            addCriterion("picture_id >=", value, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdLessThan(Long value) {
            addCriterion("picture_id <", value, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdLessThanOrEqualTo(Long value) {
            addCriterion("picture_id <=", value, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdIn(List<Long> values) {
            addCriterion("picture_id in", values, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdNotIn(List<Long> values) {
            addCriterion("picture_id not in", values, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdBetween(Long value1, Long value2) {
            addCriterion("picture_id between", value1, value2, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdNotBetween(Long value1, Long value2) {
            addCriterion("picture_id not between", value1, value2, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureNameIsNull() {
            addCriterion("picture_name is null");
            return (Criteria) this;
        }

        public Criteria andPictureNameIsNotNull() {
            addCriterion("picture_name is not null");
            return (Criteria) this;
        }

        public Criteria andPictureNameEqualTo(String value) {
            addCriterion("picture_name =", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameNotEqualTo(String value) {
            addCriterion("picture_name <>", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameGreaterThan(String value) {
            addCriterion("picture_name >", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameGreaterThanOrEqualTo(String value) {
            addCriterion("picture_name >=", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameLessThan(String value) {
            addCriterion("picture_name <", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameLessThanOrEqualTo(String value) {
            addCriterion("picture_name <=", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameLike(String value) {
            addCriterion("picture_name like", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameNotLike(String value) {
            addCriterion("picture_name not like", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameIn(List<String> values) {
            addCriterion("picture_name in", values, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameNotIn(List<String> values) {
            addCriterion("picture_name not in", values, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameBetween(String value1, String value2) {
            addCriterion("picture_name between", value1, value2, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameNotBetween(String value1, String value2) {
            addCriterion("picture_name not between", value1, value2, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureResourceIsNull() {
            addCriterion("picture_resource is null");
            return (Criteria) this;
        }

        public Criteria andPictureResourceIsNotNull() {
            addCriterion("picture_resource is not null");
            return (Criteria) this;
        }

        public Criteria andPictureResourceEqualTo(String value) {
            addCriterion("picture_resource =", value, "pictureResource");
            return (Criteria) this;
        }

        public Criteria andPictureResourceNotEqualTo(String value) {
            addCriterion("picture_resource <>", value, "pictureResource");
            return (Criteria) this;
        }

        public Criteria andPictureResourceGreaterThan(String value) {
            addCriterion("picture_resource >", value, "pictureResource");
            return (Criteria) this;
        }

        public Criteria andPictureResourceGreaterThanOrEqualTo(String value) {
            addCriterion("picture_resource >=", value, "pictureResource");
            return (Criteria) this;
        }

        public Criteria andPictureResourceLessThan(String value) {
            addCriterion("picture_resource <", value, "pictureResource");
            return (Criteria) this;
        }

        public Criteria andPictureResourceLessThanOrEqualTo(String value) {
            addCriterion("picture_resource <=", value, "pictureResource");
            return (Criteria) this;
        }

        public Criteria andPictureResourceLike(String value) {
            addCriterion("picture_resource like", value, "pictureResource");
            return (Criteria) this;
        }

        public Criteria andPictureResourceNotLike(String value) {
            addCriterion("picture_resource not like", value, "pictureResource");
            return (Criteria) this;
        }

        public Criteria andPictureResourceIn(List<String> values) {
            addCriterion("picture_resource in", values, "pictureResource");
            return (Criteria) this;
        }

        public Criteria andPictureResourceNotIn(List<String> values) {
            addCriterion("picture_resource not in", values, "pictureResource");
            return (Criteria) this;
        }

        public Criteria andPictureResourceBetween(String value1, String value2) {
            addCriterion("picture_resource between", value1, value2, "pictureResource");
            return (Criteria) this;
        }

        public Criteria andPictureResourceNotBetween(String value1, String value2) {
            addCriterion("picture_resource not between", value1, value2, "pictureResource");
            return (Criteria) this;
        }

        public Criteria andPictureStatusIsNull() {
            addCriterion("picture_status is null");
            return (Criteria) this;
        }

        public Criteria andPictureStatusIsNotNull() {
            addCriterion("picture_status is not null");
            return (Criteria) this;
        }

        public Criteria andPictureStatusEqualTo(Boolean value) {
            addCriterion("picture_status =", value, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusNotEqualTo(Boolean value) {
            addCriterion("picture_status <>", value, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusGreaterThan(Boolean value) {
            addCriterion("picture_status >", value, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("picture_status >=", value, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusLessThan(Boolean value) {
            addCriterion("picture_status <", value, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("picture_status <=", value, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusIn(List<Boolean> values) {
            addCriterion("picture_status in", values, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusNotIn(List<Boolean> values) {
            addCriterion("picture_status not in", values, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("picture_status between", value1, value2, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("picture_status not between", value1, value2, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureOrdernumIsNull() {
            addCriterion("picture_orderNum is null");
            return (Criteria) this;
        }

        public Criteria andPictureOrdernumIsNotNull() {
            addCriterion("picture_orderNum is not null");
            return (Criteria) this;
        }

        public Criteria andPictureOrdernumEqualTo(Integer value) {
            addCriterion("picture_orderNum =", value, "pictureOrdernum");
            return (Criteria) this;
        }

        public Criteria andPictureOrdernumNotEqualTo(Integer value) {
            addCriterion("picture_orderNum <>", value, "pictureOrdernum");
            return (Criteria) this;
        }

        public Criteria andPictureOrdernumGreaterThan(Integer value) {
            addCriterion("picture_orderNum >", value, "pictureOrdernum");
            return (Criteria) this;
        }

        public Criteria andPictureOrdernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("picture_orderNum >=", value, "pictureOrdernum");
            return (Criteria) this;
        }

        public Criteria andPictureOrdernumLessThan(Integer value) {
            addCriterion("picture_orderNum <", value, "pictureOrdernum");
            return (Criteria) this;
        }

        public Criteria andPictureOrdernumLessThanOrEqualTo(Integer value) {
            addCriterion("picture_orderNum <=", value, "pictureOrdernum");
            return (Criteria) this;
        }

        public Criteria andPictureOrdernumIn(List<Integer> values) {
            addCriterion("picture_orderNum in", values, "pictureOrdernum");
            return (Criteria) this;
        }

        public Criteria andPictureOrdernumNotIn(List<Integer> values) {
            addCriterion("picture_orderNum not in", values, "pictureOrdernum");
            return (Criteria) this;
        }

        public Criteria andPictureOrdernumBetween(Integer value1, Integer value2) {
            addCriterion("picture_orderNum between", value1, value2, "pictureOrdernum");
            return (Criteria) this;
        }

        public Criteria andPictureOrdernumNotBetween(Integer value1, Integer value2) {
            addCriterion("picture_orderNum not between", value1, value2, "pictureOrdernum");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Long value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Long value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Long value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Long value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Long> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Long> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Long value1, Long value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedIsNull() {
            addCriterion("picture_created is null");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedIsNotNull() {
            addCriterion("picture_created is not null");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedEqualTo(Date value) {
            addCriterion("picture_created =", value, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedNotEqualTo(Date value) {
            addCriterion("picture_created <>", value, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedGreaterThan(Date value) {
            addCriterion("picture_created >", value, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("picture_created >=", value, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedLessThan(Date value) {
            addCriterion("picture_created <", value, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedLessThanOrEqualTo(Date value) {
            addCriterion("picture_created <=", value, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedIn(List<Date> values) {
            addCriterion("picture_created in", values, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedNotIn(List<Date> values) {
            addCriterion("picture_created not in", values, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedBetween(Date value1, Date value2) {
            addCriterion("picture_created between", value1, value2, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedNotBetween(Date value1, Date value2) {
            addCriterion("picture_created not between", value1, value2, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedIsNull() {
            addCriterion("picture_updated is null");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedIsNotNull() {
            addCriterion("picture_updated is not null");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedEqualTo(Date value) {
            addCriterion("picture_updated =", value, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedNotEqualTo(Date value) {
            addCriterion("picture_updated <>", value, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedGreaterThan(Date value) {
            addCriterion("picture_updated >", value, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("picture_updated >=", value, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedLessThan(Date value) {
            addCriterion("picture_updated <", value, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("picture_updated <=", value, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedIn(List<Date> values) {
            addCriterion("picture_updated in", values, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedNotIn(List<Date> values) {
            addCriterion("picture_updated not in", values, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedBetween(Date value1, Date value2) {
            addCriterion("picture_updated between", value1, value2, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("picture_updated not between", value1, value2, "pictureUpdated");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}