package com.keji.blog.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogCommentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogCommentsExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Long value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Long value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Long value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Long value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Long value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Long> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Long> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Long value1, Long value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Long value1, Long value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
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

        public Criteria andCommentCreatedIsNull() {
            addCriterion("comment_created is null");
            return (Criteria) this;
        }

        public Criteria andCommentCreatedIsNotNull() {
            addCriterion("comment_created is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCreatedEqualTo(Date value) {
            addCriterion("comment_created =", value, "commentCreated");
            return (Criteria) this;
        }

        public Criteria andCommentCreatedNotEqualTo(Date value) {
            addCriterion("comment_created <>", value, "commentCreated");
            return (Criteria) this;
        }

        public Criteria andCommentCreatedGreaterThan(Date value) {
            addCriterion("comment_created >", value, "commentCreated");
            return (Criteria) this;
        }

        public Criteria andCommentCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_created >=", value, "commentCreated");
            return (Criteria) this;
        }

        public Criteria andCommentCreatedLessThan(Date value) {
            addCriterion("comment_created <", value, "commentCreated");
            return (Criteria) this;
        }

        public Criteria andCommentCreatedLessThanOrEqualTo(Date value) {
            addCriterion("comment_created <=", value, "commentCreated");
            return (Criteria) this;
        }

        public Criteria andCommentCreatedIn(List<Date> values) {
            addCriterion("comment_created in", values, "commentCreated");
            return (Criteria) this;
        }

        public Criteria andCommentCreatedNotIn(List<Date> values) {
            addCriterion("comment_created not in", values, "commentCreated");
            return (Criteria) this;
        }

        public Criteria andCommentCreatedBetween(Date value1, Date value2) {
            addCriterion("comment_created between", value1, value2, "commentCreated");
            return (Criteria) this;
        }

        public Criteria andCommentCreatedNotBetween(Date value1, Date value2) {
            addCriterion("comment_created not between", value1, value2, "commentCreated");
            return (Criteria) this;
        }

        public Criteria andCommentUpdatedIsNull() {
            addCriterion("comment_updated is null");
            return (Criteria) this;
        }

        public Criteria andCommentUpdatedIsNotNull() {
            addCriterion("comment_updated is not null");
            return (Criteria) this;
        }

        public Criteria andCommentUpdatedEqualTo(Date value) {
            addCriterion("comment_updated =", value, "commentUpdated");
            return (Criteria) this;
        }

        public Criteria andCommentUpdatedNotEqualTo(Date value) {
            addCriterion("comment_updated <>", value, "commentUpdated");
            return (Criteria) this;
        }

        public Criteria andCommentUpdatedGreaterThan(Date value) {
            addCriterion("comment_updated >", value, "commentUpdated");
            return (Criteria) this;
        }

        public Criteria andCommentUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_updated >=", value, "commentUpdated");
            return (Criteria) this;
        }

        public Criteria andCommentUpdatedLessThan(Date value) {
            addCriterion("comment_updated <", value, "commentUpdated");
            return (Criteria) this;
        }

        public Criteria andCommentUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("comment_updated <=", value, "commentUpdated");
            return (Criteria) this;
        }

        public Criteria andCommentUpdatedIn(List<Date> values) {
            addCriterion("comment_updated in", values, "commentUpdated");
            return (Criteria) this;
        }

        public Criteria andCommentUpdatedNotIn(List<Date> values) {
            addCriterion("comment_updated not in", values, "commentUpdated");
            return (Criteria) this;
        }

        public Criteria andCommentUpdatedBetween(Date value1, Date value2) {
            addCriterion("comment_updated between", value1, value2, "commentUpdated");
            return (Criteria) this;
        }

        public Criteria andCommentUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("comment_updated not between", value1, value2, "commentUpdated");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNull() {
            addCriterion("comment_status is null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNotNull() {
            addCriterion("comment_status is not null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusEqualTo(Boolean value) {
            addCriterion("comment_status =", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotEqualTo(Boolean value) {
            addCriterion("comment_status <>", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThan(Boolean value) {
            addCriterion("comment_status >", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("comment_status >=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThan(Boolean value) {
            addCriterion("comment_status <", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("comment_status <=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIn(List<Boolean> values) {
            addCriterion("comment_status in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotIn(List<Boolean> values) {
            addCriterion("comment_status not in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("comment_status between", value1, value2, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("comment_status not between", value1, value2, "commentStatus");
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