package com.keji.blog.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogArticleExample() {
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

        public Criteria andArticleTitleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleEqualTo(String value) {
            addCriterion("article_title =", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThan(String value) {
            addCriterion("article_title >", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThan(String value) {
            addCriterion("article_title <", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLike(String value) {
            addCriterion("article_title like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotLike(String value) {
            addCriterion("article_title not like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIn(List<String> values) {
            addCriterion("article_title in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIsNull() {
            addCriterion("article_status is null");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIsNotNull() {
            addCriterion("article_status is not null");
            return (Criteria) this;
        }

        public Criteria andArticleStatusEqualTo(Boolean value) {
            addCriterion("article_status =", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotEqualTo(Boolean value) {
            addCriterion("article_status <>", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusGreaterThan(Boolean value) {
            addCriterion("article_status >", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("article_status >=", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLessThan(Boolean value) {
            addCriterion("article_status <", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("article_status <=", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIn(List<Boolean> values) {
            addCriterion("article_status in", values, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotIn(List<Boolean> values) {
            addCriterion("article_status not in", values, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("article_status between", value1, value2, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("article_status not between", value1, value2, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleIstopIsNull() {
            addCriterion("article_isTop is null");
            return (Criteria) this;
        }

        public Criteria andArticleIstopIsNotNull() {
            addCriterion("article_isTop is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIstopEqualTo(Boolean value) {
            addCriterion("article_isTop =", value, "articleIstop");
            return (Criteria) this;
        }

        public Criteria andArticleIstopNotEqualTo(Boolean value) {
            addCriterion("article_isTop <>", value, "articleIstop");
            return (Criteria) this;
        }

        public Criteria andArticleIstopGreaterThan(Boolean value) {
            addCriterion("article_isTop >", value, "articleIstop");
            return (Criteria) this;
        }

        public Criteria andArticleIstopGreaterThanOrEqualTo(Boolean value) {
            addCriterion("article_isTop >=", value, "articleIstop");
            return (Criteria) this;
        }

        public Criteria andArticleIstopLessThan(Boolean value) {
            addCriterion("article_isTop <", value, "articleIstop");
            return (Criteria) this;
        }

        public Criteria andArticleIstopLessThanOrEqualTo(Boolean value) {
            addCriterion("article_isTop <=", value, "articleIstop");
            return (Criteria) this;
        }

        public Criteria andArticleIstopIn(List<Boolean> values) {
            addCriterion("article_isTop in", values, "articleIstop");
            return (Criteria) this;
        }

        public Criteria andArticleIstopNotIn(List<Boolean> values) {
            addCriterion("article_isTop not in", values, "articleIstop");
            return (Criteria) this;
        }

        public Criteria andArticleIstopBetween(Boolean value1, Boolean value2) {
            addCriterion("article_isTop between", value1, value2, "articleIstop");
            return (Criteria) this;
        }

        public Criteria andArticleIstopNotBetween(Boolean value1, Boolean value2) {
            addCriterion("article_isTop not between", value1, value2, "articleIstop");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Long value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Long value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Long value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Long value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Long> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Long> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Long value1, Long value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andArticleCreatedIsNull() {
            addCriterion("article_created is null");
            return (Criteria) this;
        }

        public Criteria andArticleCreatedIsNotNull() {
            addCriterion("article_created is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCreatedEqualTo(Date value) {
            addCriterion("article_created =", value, "articleCreated");
            return (Criteria) this;
        }

        public Criteria andArticleCreatedNotEqualTo(Date value) {
            addCriterion("article_created <>", value, "articleCreated");
            return (Criteria) this;
        }

        public Criteria andArticleCreatedGreaterThan(Date value) {
            addCriterion("article_created >", value, "articleCreated");
            return (Criteria) this;
        }

        public Criteria andArticleCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("article_created >=", value, "articleCreated");
            return (Criteria) this;
        }

        public Criteria andArticleCreatedLessThan(Date value) {
            addCriterion("article_created <", value, "articleCreated");
            return (Criteria) this;
        }

        public Criteria andArticleCreatedLessThanOrEqualTo(Date value) {
            addCriterion("article_created <=", value, "articleCreated");
            return (Criteria) this;
        }

        public Criteria andArticleCreatedIn(List<Date> values) {
            addCriterion("article_created in", values, "articleCreated");
            return (Criteria) this;
        }

        public Criteria andArticleCreatedNotIn(List<Date> values) {
            addCriterion("article_created not in", values, "articleCreated");
            return (Criteria) this;
        }

        public Criteria andArticleCreatedBetween(Date value1, Date value2) {
            addCriterion("article_created between", value1, value2, "articleCreated");
            return (Criteria) this;
        }

        public Criteria andArticleCreatedNotBetween(Date value1, Date value2) {
            addCriterion("article_created not between", value1, value2, "articleCreated");
            return (Criteria) this;
        }

        public Criteria andArticleUpdatedIsNull() {
            addCriterion("article_updated is null");
            return (Criteria) this;
        }

        public Criteria andArticleUpdatedIsNotNull() {
            addCriterion("article_updated is not null");
            return (Criteria) this;
        }

        public Criteria andArticleUpdatedEqualTo(Date value) {
            addCriterion("article_updated =", value, "articleUpdated");
            return (Criteria) this;
        }

        public Criteria andArticleUpdatedNotEqualTo(Date value) {
            addCriterion("article_updated <>", value, "articleUpdated");
            return (Criteria) this;
        }

        public Criteria andArticleUpdatedGreaterThan(Date value) {
            addCriterion("article_updated >", value, "articleUpdated");
            return (Criteria) this;
        }

        public Criteria andArticleUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("article_updated >=", value, "articleUpdated");
            return (Criteria) this;
        }

        public Criteria andArticleUpdatedLessThan(Date value) {
            addCriterion("article_updated <", value, "articleUpdated");
            return (Criteria) this;
        }

        public Criteria andArticleUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("article_updated <=", value, "articleUpdated");
            return (Criteria) this;
        }

        public Criteria andArticleUpdatedIn(List<Date> values) {
            addCriterion("article_updated in", values, "articleUpdated");
            return (Criteria) this;
        }

        public Criteria andArticleUpdatedNotIn(List<Date> values) {
            addCriterion("article_updated not in", values, "articleUpdated");
            return (Criteria) this;
        }

        public Criteria andArticleUpdatedBetween(Date value1, Date value2) {
            addCriterion("article_updated between", value1, value2, "articleUpdated");
            return (Criteria) this;
        }

        public Criteria andArticleUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("article_updated not between", value1, value2, "articleUpdated");
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