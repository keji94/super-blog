package com.keji.blog.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogHitsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogHitsExample() {
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

        public Criteria andHitsIdIsNull() {
            addCriterion("hits_id is null");
            return (Criteria) this;
        }

        public Criteria andHitsIdIsNotNull() {
            addCriterion("hits_id is not null");
            return (Criteria) this;
        }

        public Criteria andHitsIdEqualTo(Long value) {
            addCriterion("hits_id =", value, "hitsId");
            return (Criteria) this;
        }

        public Criteria andHitsIdNotEqualTo(Long value) {
            addCriterion("hits_id <>", value, "hitsId");
            return (Criteria) this;
        }

        public Criteria andHitsIdGreaterThan(Long value) {
            addCriterion("hits_id >", value, "hitsId");
            return (Criteria) this;
        }

        public Criteria andHitsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("hits_id >=", value, "hitsId");
            return (Criteria) this;
        }

        public Criteria andHitsIdLessThan(Long value) {
            addCriterion("hits_id <", value, "hitsId");
            return (Criteria) this;
        }

        public Criteria andHitsIdLessThanOrEqualTo(Long value) {
            addCriterion("hits_id <=", value, "hitsId");
            return (Criteria) this;
        }

        public Criteria andHitsIdIn(List<Long> values) {
            addCriterion("hits_id in", values, "hitsId");
            return (Criteria) this;
        }

        public Criteria andHitsIdNotIn(List<Long> values) {
            addCriterion("hits_id not in", values, "hitsId");
            return (Criteria) this;
        }

        public Criteria andHitsIdBetween(Long value1, Long value2) {
            addCriterion("hits_id between", value1, value2, "hitsId");
            return (Criteria) this;
        }

        public Criteria andHitsIdNotBetween(Long value1, Long value2) {
            addCriterion("hits_id not between", value1, value2, "hitsId");
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

        public Criteria andHitCountIsNull() {
            addCriterion("hit_count is null");
            return (Criteria) this;
        }

        public Criteria andHitCountIsNotNull() {
            addCriterion("hit_count is not null");
            return (Criteria) this;
        }

        public Criteria andHitCountEqualTo(Long value) {
            addCriterion("hit_count =", value, "hitCount");
            return (Criteria) this;
        }

        public Criteria andHitCountNotEqualTo(Long value) {
            addCriterion("hit_count <>", value, "hitCount");
            return (Criteria) this;
        }

        public Criteria andHitCountGreaterThan(Long value) {
            addCriterion("hit_count >", value, "hitCount");
            return (Criteria) this;
        }

        public Criteria andHitCountGreaterThanOrEqualTo(Long value) {
            addCriterion("hit_count >=", value, "hitCount");
            return (Criteria) this;
        }

        public Criteria andHitCountLessThan(Long value) {
            addCriterion("hit_count <", value, "hitCount");
            return (Criteria) this;
        }

        public Criteria andHitCountLessThanOrEqualTo(Long value) {
            addCriterion("hit_count <=", value, "hitCount");
            return (Criteria) this;
        }

        public Criteria andHitCountIn(List<Long> values) {
            addCriterion("hit_count in", values, "hitCount");
            return (Criteria) this;
        }

        public Criteria andHitCountNotIn(List<Long> values) {
            addCriterion("hit_count not in", values, "hitCount");
            return (Criteria) this;
        }

        public Criteria andHitCountBetween(Long value1, Long value2) {
            addCriterion("hit_count between", value1, value2, "hitCount");
            return (Criteria) this;
        }

        public Criteria andHitCountNotBetween(Long value1, Long value2) {
            addCriterion("hit_count not between", value1, value2, "hitCount");
            return (Criteria) this;
        }

        public Criteria andHitsCreatedIsNull() {
            addCriterion("hits_created is null");
            return (Criteria) this;
        }

        public Criteria andHitsCreatedIsNotNull() {
            addCriterion("hits_created is not null");
            return (Criteria) this;
        }

        public Criteria andHitsCreatedEqualTo(Date value) {
            addCriterion("hits_created =", value, "hitsCreated");
            return (Criteria) this;
        }

        public Criteria andHitsCreatedNotEqualTo(Date value) {
            addCriterion("hits_created <>", value, "hitsCreated");
            return (Criteria) this;
        }

        public Criteria andHitsCreatedGreaterThan(Date value) {
            addCriterion("hits_created >", value, "hitsCreated");
            return (Criteria) this;
        }

        public Criteria andHitsCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("hits_created >=", value, "hitsCreated");
            return (Criteria) this;
        }

        public Criteria andHitsCreatedLessThan(Date value) {
            addCriterion("hits_created <", value, "hitsCreated");
            return (Criteria) this;
        }

        public Criteria andHitsCreatedLessThanOrEqualTo(Date value) {
            addCriterion("hits_created <=", value, "hitsCreated");
            return (Criteria) this;
        }

        public Criteria andHitsCreatedIn(List<Date> values) {
            addCriterion("hits_created in", values, "hitsCreated");
            return (Criteria) this;
        }

        public Criteria andHitsCreatedNotIn(List<Date> values) {
            addCriterion("hits_created not in", values, "hitsCreated");
            return (Criteria) this;
        }

        public Criteria andHitsCreatedBetween(Date value1, Date value2) {
            addCriterion("hits_created between", value1, value2, "hitsCreated");
            return (Criteria) this;
        }

        public Criteria andHitsCreatedNotBetween(Date value1, Date value2) {
            addCriterion("hits_created not between", value1, value2, "hitsCreated");
            return (Criteria) this;
        }

        public Criteria andHitsUpdatedIsNull() {
            addCriterion("hits_updated is null");
            return (Criteria) this;
        }

        public Criteria andHitsUpdatedIsNotNull() {
            addCriterion("hits_updated is not null");
            return (Criteria) this;
        }

        public Criteria andHitsUpdatedEqualTo(Date value) {
            addCriterion("hits_updated =", value, "hitsUpdated");
            return (Criteria) this;
        }

        public Criteria andHitsUpdatedNotEqualTo(Date value) {
            addCriterion("hits_updated <>", value, "hitsUpdated");
            return (Criteria) this;
        }

        public Criteria andHitsUpdatedGreaterThan(Date value) {
            addCriterion("hits_updated >", value, "hitsUpdated");
            return (Criteria) this;
        }

        public Criteria andHitsUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("hits_updated >=", value, "hitsUpdated");
            return (Criteria) this;
        }

        public Criteria andHitsUpdatedLessThan(Date value) {
            addCriterion("hits_updated <", value, "hitsUpdated");
            return (Criteria) this;
        }

        public Criteria andHitsUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("hits_updated <=", value, "hitsUpdated");
            return (Criteria) this;
        }

        public Criteria andHitsUpdatedIn(List<Date> values) {
            addCriterion("hits_updated in", values, "hitsUpdated");
            return (Criteria) this;
        }

        public Criteria andHitsUpdatedNotIn(List<Date> values) {
            addCriterion("hits_updated not in", values, "hitsUpdated");
            return (Criteria) this;
        }

        public Criteria andHitsUpdatedBetween(Date value1, Date value2) {
            addCriterion("hits_updated between", value1, value2, "hitsUpdated");
            return (Criteria) this;
        }

        public Criteria andHitsUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("hits_updated not between", value1, value2, "hitsUpdated");
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