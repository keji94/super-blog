package com.keji.blog.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogArticleExtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogArticleExtExample() {
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

        public Criteria andExtIdIsNull() {
            addCriterion("ext_id is null");
            return (Criteria) this;
        }

        public Criteria andExtIdIsNotNull() {
            addCriterion("ext_id is not null");
            return (Criteria) this;
        }

        public Criteria andExtIdEqualTo(Long value) {
            addCriterion("ext_id =", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdNotEqualTo(Long value) {
            addCriterion("ext_id <>", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdGreaterThan(Long value) {
            addCriterion("ext_id >", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ext_id >=", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdLessThan(Long value) {
            addCriterion("ext_id <", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdLessThanOrEqualTo(Long value) {
            addCriterion("ext_id <=", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdIn(List<Long> values) {
            addCriterion("ext_id in", values, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdNotIn(List<Long> values) {
            addCriterion("ext_id not in", values, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdBetween(Long value1, Long value2) {
            addCriterion("ext_id between", value1, value2, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdNotBetween(Long value1, Long value2) {
            addCriterion("ext_id not between", value1, value2, "extId");
            return (Criteria) this;
        }

        public Criteria andExtGoodIsNull() {
            addCriterion("ext_good is null");
            return (Criteria) this;
        }

        public Criteria andExtGoodIsNotNull() {
            addCriterion("ext_good is not null");
            return (Criteria) this;
        }

        public Criteria andExtGoodEqualTo(Integer value) {
            addCriterion("ext_good =", value, "extGood");
            return (Criteria) this;
        }

        public Criteria andExtGoodNotEqualTo(Integer value) {
            addCriterion("ext_good <>", value, "extGood");
            return (Criteria) this;
        }

        public Criteria andExtGoodGreaterThan(Integer value) {
            addCriterion("ext_good >", value, "extGood");
            return (Criteria) this;
        }

        public Criteria andExtGoodGreaterThanOrEqualTo(Integer value) {
            addCriterion("ext_good >=", value, "extGood");
            return (Criteria) this;
        }

        public Criteria andExtGoodLessThan(Integer value) {
            addCriterion("ext_good <", value, "extGood");
            return (Criteria) this;
        }

        public Criteria andExtGoodLessThanOrEqualTo(Integer value) {
            addCriterion("ext_good <=", value, "extGood");
            return (Criteria) this;
        }

        public Criteria andExtGoodIn(List<Integer> values) {
            addCriterion("ext_good in", values, "extGood");
            return (Criteria) this;
        }

        public Criteria andExtGoodNotIn(List<Integer> values) {
            addCriterion("ext_good not in", values, "extGood");
            return (Criteria) this;
        }

        public Criteria andExtGoodBetween(Integer value1, Integer value2) {
            addCriterion("ext_good between", value1, value2, "extGood");
            return (Criteria) this;
        }

        public Criteria andExtGoodNotBetween(Integer value1, Integer value2) {
            addCriterion("ext_good not between", value1, value2, "extGood");
            return (Criteria) this;
        }

        public Criteria andExtBadIsNull() {
            addCriterion("ext_bad is null");
            return (Criteria) this;
        }

        public Criteria andExtBadIsNotNull() {
            addCriterion("ext_bad is not null");
            return (Criteria) this;
        }

        public Criteria andExtBadEqualTo(Integer value) {
            addCriterion("ext_bad =", value, "extBad");
            return (Criteria) this;
        }

        public Criteria andExtBadNotEqualTo(Integer value) {
            addCriterion("ext_bad <>", value, "extBad");
            return (Criteria) this;
        }

        public Criteria andExtBadGreaterThan(Integer value) {
            addCriterion("ext_bad >", value, "extBad");
            return (Criteria) this;
        }

        public Criteria andExtBadGreaterThanOrEqualTo(Integer value) {
            addCriterion("ext_bad >=", value, "extBad");
            return (Criteria) this;
        }

        public Criteria andExtBadLessThan(Integer value) {
            addCriterion("ext_bad <", value, "extBad");
            return (Criteria) this;
        }

        public Criteria andExtBadLessThanOrEqualTo(Integer value) {
            addCriterion("ext_bad <=", value, "extBad");
            return (Criteria) this;
        }

        public Criteria andExtBadIn(List<Integer> values) {
            addCriterion("ext_bad in", values, "extBad");
            return (Criteria) this;
        }

        public Criteria andExtBadNotIn(List<Integer> values) {
            addCriterion("ext_bad not in", values, "extBad");
            return (Criteria) this;
        }

        public Criteria andExtBadBetween(Integer value1, Integer value2) {
            addCriterion("ext_bad between", value1, value2, "extBad");
            return (Criteria) this;
        }

        public Criteria andExtBadNotBetween(Integer value1, Integer value2) {
            addCriterion("ext_bad not between", value1, value2, "extBad");
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

        public Criteria andExtCreateIsNull() {
            addCriterion("ext_create is null");
            return (Criteria) this;
        }

        public Criteria andExtCreateIsNotNull() {
            addCriterion("ext_create is not null");
            return (Criteria) this;
        }

        public Criteria andExtCreateEqualTo(Date value) {
            addCriterion("ext_create =", value, "extCreate");
            return (Criteria) this;
        }

        public Criteria andExtCreateNotEqualTo(Date value) {
            addCriterion("ext_create <>", value, "extCreate");
            return (Criteria) this;
        }

        public Criteria andExtCreateGreaterThan(Date value) {
            addCriterion("ext_create >", value, "extCreate");
            return (Criteria) this;
        }

        public Criteria andExtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("ext_create >=", value, "extCreate");
            return (Criteria) this;
        }

        public Criteria andExtCreateLessThan(Date value) {
            addCriterion("ext_create <", value, "extCreate");
            return (Criteria) this;
        }

        public Criteria andExtCreateLessThanOrEqualTo(Date value) {
            addCriterion("ext_create <=", value, "extCreate");
            return (Criteria) this;
        }

        public Criteria andExtCreateIn(List<Date> values) {
            addCriterion("ext_create in", values, "extCreate");
            return (Criteria) this;
        }

        public Criteria andExtCreateNotIn(List<Date> values) {
            addCriterion("ext_create not in", values, "extCreate");
            return (Criteria) this;
        }

        public Criteria andExtCreateBetween(Date value1, Date value2) {
            addCriterion("ext_create between", value1, value2, "extCreate");
            return (Criteria) this;
        }

        public Criteria andExtCreateNotBetween(Date value1, Date value2) {
            addCriterion("ext_create not between", value1, value2, "extCreate");
            return (Criteria) this;
        }

        public Criteria andExtUpdatedIsNull() {
            addCriterion("ext_updated is null");
            return (Criteria) this;
        }

        public Criteria andExtUpdatedIsNotNull() {
            addCriterion("ext_updated is not null");
            return (Criteria) this;
        }

        public Criteria andExtUpdatedEqualTo(Date value) {
            addCriterion("ext_updated =", value, "extUpdated");
            return (Criteria) this;
        }

        public Criteria andExtUpdatedNotEqualTo(Date value) {
            addCriterion("ext_updated <>", value, "extUpdated");
            return (Criteria) this;
        }

        public Criteria andExtUpdatedGreaterThan(Date value) {
            addCriterion("ext_updated >", value, "extUpdated");
            return (Criteria) this;
        }

        public Criteria andExtUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("ext_updated >=", value, "extUpdated");
            return (Criteria) this;
        }

        public Criteria andExtUpdatedLessThan(Date value) {
            addCriterion("ext_updated <", value, "extUpdated");
            return (Criteria) this;
        }

        public Criteria andExtUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("ext_updated <=", value, "extUpdated");
            return (Criteria) this;
        }

        public Criteria andExtUpdatedIn(List<Date> values) {
            addCriterion("ext_updated in", values, "extUpdated");
            return (Criteria) this;
        }

        public Criteria andExtUpdatedNotIn(List<Date> values) {
            addCriterion("ext_updated not in", values, "extUpdated");
            return (Criteria) this;
        }

        public Criteria andExtUpdatedBetween(Date value1, Date value2) {
            addCriterion("ext_updated between", value1, value2, "extUpdated");
            return (Criteria) this;
        }

        public Criteria andExtUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("ext_updated not between", value1, value2, "extUpdated");
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