package com.keji.blog.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogCategoryExample() {
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

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryStatusIsNull() {
            addCriterion("category_status is null");
            return (Criteria) this;
        }

        public Criteria andCategoryStatusIsNotNull() {
            addCriterion("category_status is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryStatusEqualTo(Boolean value) {
            addCriterion("category_status =", value, "categoryStatus");
            return (Criteria) this;
        }

        public Criteria andCategoryStatusNotEqualTo(Boolean value) {
            addCriterion("category_status <>", value, "categoryStatus");
            return (Criteria) this;
        }

        public Criteria andCategoryStatusGreaterThan(Boolean value) {
            addCriterion("category_status >", value, "categoryStatus");
            return (Criteria) this;
        }

        public Criteria andCategoryStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("category_status >=", value, "categoryStatus");
            return (Criteria) this;
        }

        public Criteria andCategoryStatusLessThan(Boolean value) {
            addCriterion("category_status <", value, "categoryStatus");
            return (Criteria) this;
        }

        public Criteria andCategoryStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("category_status <=", value, "categoryStatus");
            return (Criteria) this;
        }

        public Criteria andCategoryStatusIn(List<Boolean> values) {
            addCriterion("category_status in", values, "categoryStatus");
            return (Criteria) this;
        }

        public Criteria andCategoryStatusNotIn(List<Boolean> values) {
            addCriterion("category_status not in", values, "categoryStatus");
            return (Criteria) this;
        }

        public Criteria andCategoryStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("category_status between", value1, value2, "categoryStatus");
            return (Criteria) this;
        }

        public Criteria andCategoryStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("category_status not between", value1, value2, "categoryStatus");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlIsNull() {
            addCriterion("category_url is null");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlIsNotNull() {
            addCriterion("category_url is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlEqualTo(String value) {
            addCriterion("category_url =", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlNotEqualTo(String value) {
            addCriterion("category_url <>", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlGreaterThan(String value) {
            addCriterion("category_url >", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlGreaterThanOrEqualTo(String value) {
            addCriterion("category_url >=", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlLessThan(String value) {
            addCriterion("category_url <", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlLessThanOrEqualTo(String value) {
            addCriterion("category_url <=", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlLike(String value) {
            addCriterion("category_url like", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlNotLike(String value) {
            addCriterion("category_url not like", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlIn(List<String> values) {
            addCriterion("category_url in", values, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlNotIn(List<String> values) {
            addCriterion("category_url not in", values, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlBetween(String value1, String value2) {
            addCriterion("category_url between", value1, value2, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlNotBetween(String value1, String value2) {
            addCriterion("category_url not between", value1, value2, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryOrdernumIsNull() {
            addCriterion("category_orderNum is null");
            return (Criteria) this;
        }

        public Criteria andCategoryOrdernumIsNotNull() {
            addCriterion("category_orderNum is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryOrdernumEqualTo(Integer value) {
            addCriterion("category_orderNum =", value, "categoryOrdernum");
            return (Criteria) this;
        }

        public Criteria andCategoryOrdernumNotEqualTo(Integer value) {
            addCriterion("category_orderNum <>", value, "categoryOrdernum");
            return (Criteria) this;
        }

        public Criteria andCategoryOrdernumGreaterThan(Integer value) {
            addCriterion("category_orderNum >", value, "categoryOrdernum");
            return (Criteria) this;
        }

        public Criteria andCategoryOrdernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_orderNum >=", value, "categoryOrdernum");
            return (Criteria) this;
        }

        public Criteria andCategoryOrdernumLessThan(Integer value) {
            addCriterion("category_orderNum <", value, "categoryOrdernum");
            return (Criteria) this;
        }

        public Criteria andCategoryOrdernumLessThanOrEqualTo(Integer value) {
            addCriterion("category_orderNum <=", value, "categoryOrdernum");
            return (Criteria) this;
        }

        public Criteria andCategoryOrdernumIn(List<Integer> values) {
            addCriterion("category_orderNum in", values, "categoryOrdernum");
            return (Criteria) this;
        }

        public Criteria andCategoryOrdernumNotIn(List<Integer> values) {
            addCriterion("category_orderNum not in", values, "categoryOrdernum");
            return (Criteria) this;
        }

        public Criteria andCategoryOrdernumBetween(Integer value1, Integer value2) {
            addCriterion("category_orderNum between", value1, value2, "categoryOrdernum");
            return (Criteria) this;
        }

        public Criteria andCategoryOrdernumNotBetween(Integer value1, Integer value2) {
            addCriterion("category_orderNum not between", value1, value2, "categoryOrdernum");
            return (Criteria) this;
        }

        public Criteria andCategoryIsparentIsNull() {
            addCriterion("category_isParent is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsparentIsNotNull() {
            addCriterion("category_isParent is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsparentEqualTo(Boolean value) {
            addCriterion("category_isParent =", value, "categoryIsparent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsparentNotEqualTo(Boolean value) {
            addCriterion("category_isParent <>", value, "categoryIsparent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsparentGreaterThan(Boolean value) {
            addCriterion("category_isParent >", value, "categoryIsparent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsparentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("category_isParent >=", value, "categoryIsparent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsparentLessThan(Boolean value) {
            addCriterion("category_isParent <", value, "categoryIsparent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsparentLessThanOrEqualTo(Boolean value) {
            addCriterion("category_isParent <=", value, "categoryIsparent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsparentIn(List<Boolean> values) {
            addCriterion("category_isParent in", values, "categoryIsparent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsparentNotIn(List<Boolean> values) {
            addCriterion("category_isParent not in", values, "categoryIsparent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsparentBetween(Boolean value1, Boolean value2) {
            addCriterion("category_isParent between", value1, value2, "categoryIsparent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsparentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("category_isParent not between", value1, value2, "categoryIsparent");
            return (Criteria) this;
        }

        public Criteria andCategpryParentidIsNull() {
            addCriterion("categpry_parentId is null");
            return (Criteria) this;
        }

        public Criteria andCategpryParentidIsNotNull() {
            addCriterion("categpry_parentId is not null");
            return (Criteria) this;
        }

        public Criteria andCategpryParentidEqualTo(Long value) {
            addCriterion("categpry_parentId =", value, "categpryParentid");
            return (Criteria) this;
        }

        public Criteria andCategpryParentidNotEqualTo(Long value) {
            addCriterion("categpry_parentId <>", value, "categpryParentid");
            return (Criteria) this;
        }

        public Criteria andCategpryParentidGreaterThan(Long value) {
            addCriterion("categpry_parentId >", value, "categpryParentid");
            return (Criteria) this;
        }

        public Criteria andCategpryParentidGreaterThanOrEqualTo(Long value) {
            addCriterion("categpry_parentId >=", value, "categpryParentid");
            return (Criteria) this;
        }

        public Criteria andCategpryParentidLessThan(Long value) {
            addCriterion("categpry_parentId <", value, "categpryParentid");
            return (Criteria) this;
        }

        public Criteria andCategpryParentidLessThanOrEqualTo(Long value) {
            addCriterion("categpry_parentId <=", value, "categpryParentid");
            return (Criteria) this;
        }

        public Criteria andCategpryParentidIn(List<Long> values) {
            addCriterion("categpry_parentId in", values, "categpryParentid");
            return (Criteria) this;
        }

        public Criteria andCategpryParentidNotIn(List<Long> values) {
            addCriterion("categpry_parentId not in", values, "categpryParentid");
            return (Criteria) this;
        }

        public Criteria andCategpryParentidBetween(Long value1, Long value2) {
            addCriterion("categpry_parentId between", value1, value2, "categpryParentid");
            return (Criteria) this;
        }

        public Criteria andCategpryParentidNotBetween(Long value1, Long value2) {
            addCriterion("categpry_parentId not between", value1, value2, "categpryParentid");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedIsNull() {
            addCriterion("category_created is null");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedIsNotNull() {
            addCriterion("category_created is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedEqualTo(Date value) {
            addCriterion("category_created =", value, "categoryCreated");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedNotEqualTo(Date value) {
            addCriterion("category_created <>", value, "categoryCreated");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedGreaterThan(Date value) {
            addCriterion("category_created >", value, "categoryCreated");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("category_created >=", value, "categoryCreated");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedLessThan(Date value) {
            addCriterion("category_created <", value, "categoryCreated");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedLessThanOrEqualTo(Date value) {
            addCriterion("category_created <=", value, "categoryCreated");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedIn(List<Date> values) {
            addCriterion("category_created in", values, "categoryCreated");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedNotIn(List<Date> values) {
            addCriterion("category_created not in", values, "categoryCreated");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedBetween(Date value1, Date value2) {
            addCriterion("category_created between", value1, value2, "categoryCreated");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedNotBetween(Date value1, Date value2) {
            addCriterion("category_created not between", value1, value2, "categoryCreated");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdatedIsNull() {
            addCriterion("category_updated is null");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdatedIsNotNull() {
            addCriterion("category_updated is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdatedEqualTo(Date value) {
            addCriterion("category_updated =", value, "categoryUpdated");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdatedNotEqualTo(Date value) {
            addCriterion("category_updated <>", value, "categoryUpdated");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdatedGreaterThan(Date value) {
            addCriterion("category_updated >", value, "categoryUpdated");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("category_updated >=", value, "categoryUpdated");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdatedLessThan(Date value) {
            addCriterion("category_updated <", value, "categoryUpdated");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("category_updated <=", value, "categoryUpdated");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdatedIn(List<Date> values) {
            addCriterion("category_updated in", values, "categoryUpdated");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdatedNotIn(List<Date> values) {
            addCriterion("category_updated not in", values, "categoryUpdated");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdatedBetween(Date value1, Date value2) {
            addCriterion("category_updated between", value1, value2, "categoryUpdated");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("category_updated not between", value1, value2, "categoryUpdated");
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