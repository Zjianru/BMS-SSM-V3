package com.code.bms.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LendListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LendListExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andSernumIsNull() {
            addCriterion("sernum is null");
            return (Criteria) this;
        }

        public Criteria andSernumIsNotNull() {
            addCriterion("sernum is not null");
            return (Criteria) this;
        }

        public Criteria andSernumEqualTo(Long value) {
            addCriterion("sernum =", value, "sernum");
            return (Criteria) this;
        }

        public Criteria andSernumNotEqualTo(Long value) {
            addCriterion("sernum <>", value, "sernum");
            return (Criteria) this;
        }

        public Criteria andSernumGreaterThan(Long value) {
            addCriterion("sernum >", value, "sernum");
            return (Criteria) this;
        }

        public Criteria andSernumGreaterThanOrEqualTo(Long value) {
            addCriterion("sernum >=", value, "sernum");
            return (Criteria) this;
        }

        public Criteria andSernumLessThan(Long value) {
            addCriterion("sernum <", value, "sernum");
            return (Criteria) this;
        }

        public Criteria andSernumLessThanOrEqualTo(Long value) {
            addCriterion("sernum <=", value, "sernum");
            return (Criteria) this;
        }

        public Criteria andSernumIn(List<Long> values) {
            addCriterion("sernum in", values, "sernum");
            return (Criteria) this;
        }

        public Criteria andSernumNotIn(List<Long> values) {
            addCriterion("sernum not in", values, "sernum");
            return (Criteria) this;
        }

        public Criteria andSernumBetween(Long value1, Long value2) {
            addCriterion("sernum between", value1, value2, "sernum");
            return (Criteria) this;
        }

        public Criteria andSernumNotBetween(Long value1, Long value2) {
            addCriterion("sernum not between", value1, value2, "sernum");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Long value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Long value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Long value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Long value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Long value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Long value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Long> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Long> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Long value1, Long value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Long value1, Long value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andReaderIdIsNull() {
            addCriterion("reader_id is null");
            return (Criteria) this;
        }

        public Criteria andReaderIdIsNotNull() {
            addCriterion("reader_id is not null");
            return (Criteria) this;
        }

        public Criteria andReaderIdEqualTo(Integer value) {
            addCriterion("reader_id =", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdNotEqualTo(Integer value) {
            addCriterion("reader_id <>", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdGreaterThan(Integer value) {
            addCriterion("reader_id >", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reader_id >=", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdLessThan(Integer value) {
            addCriterion("reader_id <", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdLessThanOrEqualTo(Integer value) {
            addCriterion("reader_id <=", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdIn(List<Integer> values) {
            addCriterion("reader_id in", values, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdNotIn(List<Integer> values) {
            addCriterion("reader_id not in", values, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdBetween(Integer value1, Integer value2) {
            addCriterion("reader_id between", value1, value2, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reader_id not between", value1, value2, "readerId");
            return (Criteria) this;
        }

        public Criteria andLendDateIsNull() {
            addCriterion("lend_date is null");
            return (Criteria) this;
        }

        public Criteria andLendDateIsNotNull() {
            addCriterion("lend_date is not null");
            return (Criteria) this;
        }

        public Criteria andLendDateEqualTo(Date value) {
            addCriterionForJDBCDate("lend_date =", value, "lendDate");
            return (Criteria) this;
        }

        public Criteria andLendDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("lend_date <>", value, "lendDate");
            return (Criteria) this;
        }

        public Criteria andLendDateGreaterThan(Date value) {
            addCriterionForJDBCDate("lend_date >", value, "lendDate");
            return (Criteria) this;
        }

        public Criteria andLendDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lend_date >=", value, "lendDate");
            return (Criteria) this;
        }

        public Criteria andLendDateLessThan(Date value) {
            addCriterionForJDBCDate("lend_date <", value, "lendDate");
            return (Criteria) this;
        }

        public Criteria andLendDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lend_date <=", value, "lendDate");
            return (Criteria) this;
        }

        public Criteria andLendDateIn(List<Date> values) {
            addCriterionForJDBCDate("lend_date in", values, "lendDate");
            return (Criteria) this;
        }

        public Criteria andLendDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("lend_date not in", values, "lendDate");
            return (Criteria) this;
        }

        public Criteria andLendDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lend_date between", value1, value2, "lendDate");
            return (Criteria) this;
        }

        public Criteria andLendDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lend_date not between", value1, value2, "lendDate");
            return (Criteria) this;
        }

        public Criteria andBackDateIsNull() {
            addCriterion("back_date is null");
            return (Criteria) this;
        }

        public Criteria andBackDateIsNotNull() {
            addCriterion("back_date is not null");
            return (Criteria) this;
        }

        public Criteria andBackDateEqualTo(Date value) {
            addCriterionForJDBCDate("back_date =", value, "backDate");
            return (Criteria) this;
        }

        public Criteria andBackDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("back_date <>", value, "backDate");
            return (Criteria) this;
        }

        public Criteria andBackDateGreaterThan(Date value) {
            addCriterionForJDBCDate("back_date >", value, "backDate");
            return (Criteria) this;
        }

        public Criteria andBackDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("back_date >=", value, "backDate");
            return (Criteria) this;
        }

        public Criteria andBackDateLessThan(Date value) {
            addCriterionForJDBCDate("back_date <", value, "backDate");
            return (Criteria) this;
        }

        public Criteria andBackDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("back_date <=", value, "backDate");
            return (Criteria) this;
        }

        public Criteria andBackDateIn(List<Date> values) {
            addCriterionForJDBCDate("back_date in", values, "backDate");
            return (Criteria) this;
        }

        public Criteria andBackDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("back_date not in", values, "backDate");
            return (Criteria) this;
        }

        public Criteria andBackDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("back_date between", value1, value2, "backDate");
            return (Criteria) this;
        }

        public Criteria andBackDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("back_date not between", value1, value2, "backDate");
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