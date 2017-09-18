package com.keji.blog.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogUserExample() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIsNull() {
            addCriterion("user_nickname is null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIsNotNull() {
            addCriterion("user_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameEqualTo(String value) {
            addCriterion("user_nickname =", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotEqualTo(String value) {
            addCriterion("user_nickname <>", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThan(String value) {
            addCriterion("user_nickname >", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("user_nickname >=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThan(String value) {
            addCriterion("user_nickname <", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThanOrEqualTo(String value) {
            addCriterion("user_nickname <=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLike(String value) {
            addCriterion("user_nickname like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotLike(String value) {
            addCriterion("user_nickname not like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIn(List<String> values) {
            addCriterion("user_nickname in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotIn(List<String> values) {
            addCriterion("user_nickname not in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameBetween(String value1, String value2) {
            addCriterion("user_nickname between", value1, value2, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotBetween(String value1, String value2) {
            addCriterion("user_nickname not between", value1, value2, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserQuestionIsNull() {
            addCriterion("user_question is null");
            return (Criteria) this;
        }

        public Criteria andUserQuestionIsNotNull() {
            addCriterion("user_question is not null");
            return (Criteria) this;
        }

        public Criteria andUserQuestionEqualTo(String value) {
            addCriterion("user_question =", value, "userQuestion");
            return (Criteria) this;
        }

        public Criteria andUserQuestionNotEqualTo(String value) {
            addCriterion("user_question <>", value, "userQuestion");
            return (Criteria) this;
        }

        public Criteria andUserQuestionGreaterThan(String value) {
            addCriterion("user_question >", value, "userQuestion");
            return (Criteria) this;
        }

        public Criteria andUserQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("user_question >=", value, "userQuestion");
            return (Criteria) this;
        }

        public Criteria andUserQuestionLessThan(String value) {
            addCriterion("user_question <", value, "userQuestion");
            return (Criteria) this;
        }

        public Criteria andUserQuestionLessThanOrEqualTo(String value) {
            addCriterion("user_question <=", value, "userQuestion");
            return (Criteria) this;
        }

        public Criteria andUserQuestionLike(String value) {
            addCriterion("user_question like", value, "userQuestion");
            return (Criteria) this;
        }

        public Criteria andUserQuestionNotLike(String value) {
            addCriterion("user_question not like", value, "userQuestion");
            return (Criteria) this;
        }

        public Criteria andUserQuestionIn(List<String> values) {
            addCriterion("user_question in", values, "userQuestion");
            return (Criteria) this;
        }

        public Criteria andUserQuestionNotIn(List<String> values) {
            addCriterion("user_question not in", values, "userQuestion");
            return (Criteria) this;
        }

        public Criteria andUserQuestionBetween(String value1, String value2) {
            addCriterion("user_question between", value1, value2, "userQuestion");
            return (Criteria) this;
        }

        public Criteria andUserQuestionNotBetween(String value1, String value2) {
            addCriterion("user_question not between", value1, value2, "userQuestion");
            return (Criteria) this;
        }

        public Criteria andUserAnswerIsNull() {
            addCriterion("user_answer is null");
            return (Criteria) this;
        }

        public Criteria andUserAnswerIsNotNull() {
            addCriterion("user_answer is not null");
            return (Criteria) this;
        }

        public Criteria andUserAnswerEqualTo(String value) {
            addCriterion("user_answer =", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerNotEqualTo(String value) {
            addCriterion("user_answer <>", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerGreaterThan(String value) {
            addCriterion("user_answer >", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("user_answer >=", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerLessThan(String value) {
            addCriterion("user_answer <", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerLessThanOrEqualTo(String value) {
            addCriterion("user_answer <=", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerLike(String value) {
            addCriterion("user_answer like", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerNotLike(String value) {
            addCriterion("user_answer not like", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerIn(List<String> values) {
            addCriterion("user_answer in", values, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerNotIn(List<String> values) {
            addCriterion("user_answer not in", values, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerBetween(String value1, String value2) {
            addCriterion("user_answer between", value1, value2, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerNotBetween(String value1, String value2) {
            addCriterion("user_answer not between", value1, value2, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserPictureIsNull() {
            addCriterion("user_picture is null");
            return (Criteria) this;
        }

        public Criteria andUserPictureIsNotNull() {
            addCriterion("user_picture is not null");
            return (Criteria) this;
        }

        public Criteria andUserPictureEqualTo(String value) {
            addCriterion("user_picture =", value, "userPicture");
            return (Criteria) this;
        }

        public Criteria andUserPictureNotEqualTo(String value) {
            addCriterion("user_picture <>", value, "userPicture");
            return (Criteria) this;
        }

        public Criteria andUserPictureGreaterThan(String value) {
            addCriterion("user_picture >", value, "userPicture");
            return (Criteria) this;
        }

        public Criteria andUserPictureGreaterThanOrEqualTo(String value) {
            addCriterion("user_picture >=", value, "userPicture");
            return (Criteria) this;
        }

        public Criteria andUserPictureLessThan(String value) {
            addCriterion("user_picture <", value, "userPicture");
            return (Criteria) this;
        }

        public Criteria andUserPictureLessThanOrEqualTo(String value) {
            addCriterion("user_picture <=", value, "userPicture");
            return (Criteria) this;
        }

        public Criteria andUserPictureLike(String value) {
            addCriterion("user_picture like", value, "userPicture");
            return (Criteria) this;
        }

        public Criteria andUserPictureNotLike(String value) {
            addCriterion("user_picture not like", value, "userPicture");
            return (Criteria) this;
        }

        public Criteria andUserPictureIn(List<String> values) {
            addCriterion("user_picture in", values, "userPicture");
            return (Criteria) this;
        }

        public Criteria andUserPictureNotIn(List<String> values) {
            addCriterion("user_picture not in", values, "userPicture");
            return (Criteria) this;
        }

        public Criteria andUserPictureBetween(String value1, String value2) {
            addCriterion("user_picture between", value1, value2, "userPicture");
            return (Criteria) this;
        }

        public Criteria andUserPictureNotBetween(String value1, String value2) {
            addCriterion("user_picture not between", value1, value2, "userPicture");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNull() {
            addCriterion("user_status is null");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNotNull() {
            addCriterion("user_status is not null");
            return (Criteria) this;
        }

        public Criteria andUserStatusEqualTo(Boolean value) {
            addCriterion("user_status =", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotEqualTo(Boolean value) {
            addCriterion("user_status <>", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThan(Boolean value) {
            addCriterion("user_status >", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("user_status >=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThan(Boolean value) {
            addCriterion("user_status <", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("user_status <=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusIn(List<Boolean> values) {
            addCriterion("user_status in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotIn(List<Boolean> values) {
            addCriterion("user_status not in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("user_status between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("user_status not between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserCreatedIsNull() {
            addCriterion("user_created is null");
            return (Criteria) this;
        }

        public Criteria andUserCreatedIsNotNull() {
            addCriterion("user_created is not null");
            return (Criteria) this;
        }

        public Criteria andUserCreatedEqualTo(Date value) {
            addCriterion("user_created =", value, "userCreated");
            return (Criteria) this;
        }

        public Criteria andUserCreatedNotEqualTo(Date value) {
            addCriterion("user_created <>", value, "userCreated");
            return (Criteria) this;
        }

        public Criteria andUserCreatedGreaterThan(Date value) {
            addCriterion("user_created >", value, "userCreated");
            return (Criteria) this;
        }

        public Criteria andUserCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("user_created >=", value, "userCreated");
            return (Criteria) this;
        }

        public Criteria andUserCreatedLessThan(Date value) {
            addCriterion("user_created <", value, "userCreated");
            return (Criteria) this;
        }

        public Criteria andUserCreatedLessThanOrEqualTo(Date value) {
            addCriterion("user_created <=", value, "userCreated");
            return (Criteria) this;
        }

        public Criteria andUserCreatedIn(List<Date> values) {
            addCriterion("user_created in", values, "userCreated");
            return (Criteria) this;
        }

        public Criteria andUserCreatedNotIn(List<Date> values) {
            addCriterion("user_created not in", values, "userCreated");
            return (Criteria) this;
        }

        public Criteria andUserCreatedBetween(Date value1, Date value2) {
            addCriterion("user_created between", value1, value2, "userCreated");
            return (Criteria) this;
        }

        public Criteria andUserCreatedNotBetween(Date value1, Date value2) {
            addCriterion("user_created not between", value1, value2, "userCreated");
            return (Criteria) this;
        }

        public Criteria andUserUpdatedIsNull() {
            addCriterion("user_updated is null");
            return (Criteria) this;
        }

        public Criteria andUserUpdatedIsNotNull() {
            addCriterion("user_updated is not null");
            return (Criteria) this;
        }

        public Criteria andUserUpdatedEqualTo(Date value) {
            addCriterion("user_updated =", value, "userUpdated");
            return (Criteria) this;
        }

        public Criteria andUserUpdatedNotEqualTo(Date value) {
            addCriterion("user_updated <>", value, "userUpdated");
            return (Criteria) this;
        }

        public Criteria andUserUpdatedGreaterThan(Date value) {
            addCriterion("user_updated >", value, "userUpdated");
            return (Criteria) this;
        }

        public Criteria andUserUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("user_updated >=", value, "userUpdated");
            return (Criteria) this;
        }

        public Criteria andUserUpdatedLessThan(Date value) {
            addCriterion("user_updated <", value, "userUpdated");
            return (Criteria) this;
        }

        public Criteria andUserUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("user_updated <=", value, "userUpdated");
            return (Criteria) this;
        }

        public Criteria andUserUpdatedIn(List<Date> values) {
            addCriterion("user_updated in", values, "userUpdated");
            return (Criteria) this;
        }

        public Criteria andUserUpdatedNotIn(List<Date> values) {
            addCriterion("user_updated not in", values, "userUpdated");
            return (Criteria) this;
        }

        public Criteria andUserUpdatedBetween(Date value1, Date value2) {
            addCriterion("user_updated between", value1, value2, "userUpdated");
            return (Criteria) this;
        }

        public Criteria andUserUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("user_updated not between", value1, value2, "userUpdated");
            return (Criteria) this;
        }

        public Criteria andUserIpIsNull() {
            addCriterion("user_ip is null");
            return (Criteria) this;
        }

        public Criteria andUserIpIsNotNull() {
            addCriterion("user_ip is not null");
            return (Criteria) this;
        }

        public Criteria andUserIpEqualTo(String value) {
            addCriterion("user_ip =", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotEqualTo(String value) {
            addCriterion("user_ip <>", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpGreaterThan(String value) {
            addCriterion("user_ip >", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpGreaterThanOrEqualTo(String value) {
            addCriterion("user_ip >=", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpLessThan(String value) {
            addCriterion("user_ip <", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpLessThanOrEqualTo(String value) {
            addCriterion("user_ip <=", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpLike(String value) {
            addCriterion("user_ip like", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotLike(String value) {
            addCriterion("user_ip not like", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpIn(List<String> values) {
            addCriterion("user_ip in", values, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotIn(List<String> values) {
            addCriterion("user_ip not in", values, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpBetween(String value1, String value2) {
            addCriterion("user_ip between", value1, value2, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotBetween(String value1, String value2) {
            addCriterion("user_ip not between", value1, value2, "userIp");
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