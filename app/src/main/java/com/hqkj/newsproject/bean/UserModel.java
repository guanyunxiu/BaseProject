package com.hqkj.newsproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018\1\29 0029.
 */

public class UserModel implements Serializable {


    /**
     * address : string
     * email : string
     * id : string
     * loginName : string
     * member : {"count":0,"list":[{"content":"string","createDate":"2018-02-08T01:19:00.728Z","id":"string","oaNotifyRecordIds":"string","oaNotifyRecordNames":"string","self":true,"title":"string"}]}
     * mobile : string
     * name : string
     * no : string
     * photo : string
     * sex : string
     * token : string
     * userType : string
     */

    private String address;
    private String email;
    private String id;
    private String loginName;
    private MemberBean member;
    private String mobile;
    private String name;
    private String no;
    private String photo;
    private String sex;
    private String token;
    private String userType;
    private Office office;
    private Company company;
    private String roleNames;
    private boolean firstLogin;
    private boolean oaHidden;

    public boolean isOaHidden() {
        return oaHidden;
    }

    public void setOaHidden(boolean oaHidden) {
        this.oaHidden = oaHidden;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Office getOffice() {
        return office;
    }
    public void setOffice(Office office) {
        this.office = office;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public MemberBean getMember() {
        return member;
    }

    public void setMember(MemberBean member) {
        this.member = member;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
   public class Company implements Serializable {

       /**
        * id : 1
        * name : 山西省
        * address : null
        * zipCode : null
        * phone : null
        * fax : null
        * email : null
        * intro : null
        * workTime : null
        * transit : null
        * lnglat : null
        * icon : null
        * wechat : null
        * weibo : null
        * ios : null
        * android : null
        * site : null
        * functionList : [0,1,2,3,4]
        * caseUrl : http://www.ajxxgk.jcy.cn/html/index.html
        * lawUrl : http://www.ajxxgk.jcy.cn/html/index.html
        * supervision : null
        * parentId : 0
        */

       private String id;
       private String name;
       private Object address;
       private Object zipCode;
       private Object phone;
       private Object fax;
       private Object email;
       private Object intro;
       private Object workTime;
       private Object transit;
       private String lnglat;
       private Object icon;
       private Object wechat;
       private Object weibo;
       private Object ios;
       private Object android;
       private Object site;
       private String caseUrl;
       private String lawUrl;
       private Object supervision;
       private String parentId;
       private List<Integer> functionList;

       public String getId() {
           return id;
       }

       public void setId(String id) {
           this.id = id;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public Object getAddress() {
           return address;
       }

       public void setAddress(Object address) {
           this.address = address;
       }

       public Object getZipCode() {
           return zipCode;
       }

       public void setZipCode(Object zipCode) {
           this.zipCode = zipCode;
       }

       public Object getPhone() {
           return phone;
       }

       public void setPhone(Object phone) {
           this.phone = phone;
       }

       public Object getFax() {
           return fax;
       }

       public void setFax(Object fax) {
           this.fax = fax;
       }

       public Object getEmail() {
           return email;
       }

       public void setEmail(Object email) {
           this.email = email;
       }

       public Object getIntro() {
           return intro;
       }

       public void setIntro(Object intro) {
           this.intro = intro;
       }

       public Object getWorkTime() {
           return workTime;
       }

       public void setWorkTime(Object workTime) {
           this.workTime = workTime;
       }

       public Object getTransit() {
           return transit;
       }

       public void setTransit(Object transit) {
           this.transit = transit;
       }

       public String getLnglat() {
           return lnglat;
       }

       public void setLnglat(String lnglat) {
           this.lnglat = lnglat;
       }

       public Object getIcon() {
           return icon;
       }

       public void setIcon(Object icon) {
           this.icon = icon;
       }

       public Object getWechat() {
           return wechat;
       }

       public void setWechat(Object wechat) {
           this.wechat = wechat;
       }

       public Object getWeibo() {
           return weibo;
       }

       public void setWeibo(Object weibo) {
           this.weibo = weibo;
       }

       public Object getIos() {
           return ios;
       }

       public void setIos(Object ios) {
           this.ios = ios;
       }

       public Object getAndroid() {
           return android;
       }

       public void setAndroid(Object android) {
           this.android = android;
       }

       public Object getSite() {
           return site;
       }

       public void setSite(Object site) {
           this.site = site;
       }

       public String getCaseUrl() {
           return caseUrl;
       }

       public void setCaseUrl(String caseUrl) {
           this.caseUrl = caseUrl;
       }

       public String getLawUrl() {
           return lawUrl;
       }

       public void setLawUrl(String lawUrl) {
           this.lawUrl = lawUrl;
       }

       public Object getSupervision() {
           return supervision;
       }

       public void setSupervision(Object supervision) {
           this.supervision = supervision;
       }

       public String getParentId() {
           return parentId;
       }

       public void setParentId(String parentId) {
           this.parentId = parentId;
       }

       public List<Integer> getFunctionList() {
           return functionList;
       }

       public void setFunctionList(List<Integer> functionList) {
           this.functionList = functionList;
       }
   }
    public class Office implements Serializable {

        /**
         * id : 1
         * name : 山西省
         * address : null
         * zipCode : null
         * phone : null
         * fax : null
         * email : null
         * intro : null
         * workTime : null
         * transit : null
         * lnglat : null
         * icon : null
         * wechat : null
         * weibo : null
         * ios : null
         * android : null
         * site : null
         * functionList : [0,1,2,3,4]
         * caseUrl : http://www.ajxxgk.jcy.cn/html/index.html
         * lawUrl : http://www.ajxxgk.jcy.cn/html/index.html
         * supervision : null
         * parentId : 0
         */

        private String id;
        private String name;
        private Object address;
        private Object zipCode;
        private Object phone;
        private Object fax;
        private Object email;
        private Object intro;
        private Object workTime;
        private Object transit;
        private Object lnglat;
        private Object icon;
        private Object wechat;
        private Object weibo;
        private Object ios;
        private Object android;
        private Object site;
        private String caseUrl;
        private String lawUrl;
        private Object supervision;
        private String parentId;
        private List<Integer> functionList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public Object getZipCode() {
            return zipCode;
        }

        public void setZipCode(Object zipCode) {
            this.zipCode = zipCode;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public Object getFax() {
            return fax;
        }

        public void setFax(Object fax) {
            this.fax = fax;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getIntro() {
            return intro;
        }

        public void setIntro(Object intro) {
            this.intro = intro;
        }

        public Object getWorkTime() {
            return workTime;
        }

        public void setWorkTime(Object workTime) {
            this.workTime = workTime;
        }

        public Object getTransit() {
            return transit;
        }

        public void setTransit(Object transit) {
            this.transit = transit;
        }

        public Object getLnglat() {
            return lnglat;
        }

        public void setLnglat(Object lnglat) {
            this.lnglat = lnglat;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public Object getWechat() {
            return wechat;
        }

        public void setWechat(Object wechat) {
            this.wechat = wechat;
        }

        public Object getWeibo() {
            return weibo;
        }

        public void setWeibo(Object weibo) {
            this.weibo = weibo;
        }

        public Object getIos() {
            return ios;
        }

        public void setIos(Object ios) {
            this.ios = ios;
        }

        public Object getAndroid() {
            return android;
        }

        public void setAndroid(Object android) {
            this.android = android;
        }

        public Object getSite() {
            return site;
        }

        public void setSite(Object site) {
            this.site = site;
        }

        public String getCaseUrl() {
            return caseUrl;
        }

        public void setCaseUrl(String caseUrl) {
            this.caseUrl = caseUrl;
        }

        public String getLawUrl() {
            return lawUrl;
        }

        public void setLawUrl(String lawUrl) {
            this.lawUrl = lawUrl;
        }

        public Object getSupervision() {
            return supervision;
        }

        public void setSupervision(Object supervision) {
            this.supervision = supervision;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public List<Integer> getFunctionList() {
            return functionList;
        }

        public void setFunctionList(List<Integer> functionList) {
            this.functionList = functionList;
        }
    }
    public static class MemberBean implements Serializable {
        /**
         * count : 0
         * list : [{"content":"string","createDate":"2018-02-08T01:19:00.728Z","id":"string","oaNotifyRecordIds":"string","oaNotifyRecordNames":"string","self":true,"title":"string"}]
         */

        private int count;
        private List<ListBean> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {
            /**
             * content : string
             * createDate : 2018-02-08T01:19:00.728Z
             * id : string
             * oaNotifyRecordIds : string
             * oaNotifyRecordNames : string
             * self : true
             * title : string
             */

            private String content;
            private String createDate;
            private String id;
            private String oaNotifyRecordIds;
            private String oaNotifyRecordNames;
            private boolean self;
            private String title;
            private CreateBy createBy;

            public CreateBy getCreateBy() {
                return createBy;
            }

            public void setCreateBy(CreateBy createBy) {
                this.createBy = createBy;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOaNotifyRecordIds() {
                return oaNotifyRecordIds;
            }

            public void setOaNotifyRecordIds(String oaNotifyRecordIds) {
                this.oaNotifyRecordIds = oaNotifyRecordIds;
            }

            public String getOaNotifyRecordNames() {
                return oaNotifyRecordNames;
            }

            public void setOaNotifyRecordNames(String oaNotifyRecordNames) {
                this.oaNotifyRecordNames = oaNotifyRecordNames;
            }

            public boolean isSelf() {
                return self;
            }

            public void setSelf(boolean self) {
                this.self = self;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

        }
        public static class CreateBy implements Serializable {

            /**
             * id : 1
             * company : null
             * office : null
             * loginName : null
             * no : null
             * name : 系统管理员
             * email : null
             * mobile : null
             * userType :
             * sex : null
             * oaHidden : false
             * photo : null
             * firstLogin : false
             * address : null
             * token : null
             * roleNames :
             */

            private String id;
            private Object company;
            private Object office;
            private Object loginName;
            private Object no;
            private String name;
            private Object email;
            private Object mobile;
            private String userType;
            private Object sex;
            private boolean oaHidden;
            private Object photo;
            private boolean firstLogin;
            private Object address;
            private Object token;
            private String roleNames;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Object getCompany() {
                return company;
            }

            public void setCompany(Object company) {
                this.company = company;
            }

            public Object getOffice() {
                return office;
            }

            public void setOffice(Object office) {
                this.office = office;
            }

            public Object getLoginName() {
                return loginName;
            }

            public void setLoginName(Object loginName) {
                this.loginName = loginName;
            }

            public Object getNo() {
                return no;
            }

            public void setNo(Object no) {
                this.no = no;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public Object getMobile() {
                return mobile;
            }

            public void setMobile(Object mobile) {
                this.mobile = mobile;
            }

            public String getUserType() {
                return userType;
            }

            public void setUserType(String userType) {
                this.userType = userType;
            }

            public Object getSex() {
                return sex;
            }

            public void setSex(Object sex) {
                this.sex = sex;
            }

            public boolean isOaHidden() {
                return oaHidden;
            }

            public void setOaHidden(boolean oaHidden) {
                this.oaHidden = oaHidden;
            }

            public Object getPhoto() {
                return photo;
            }

            public void setPhoto(Object photo) {
                this.photo = photo;
            }

            public boolean isFirstLogin() {
                return firstLogin;
            }

            public void setFirstLogin(boolean firstLogin) {
                this.firstLogin = firstLogin;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public Object getToken() {
                return token;
            }

            public void setToken(Object token) {
                this.token = token;
            }

            public String getRoleNames() {
                return roleNames;
            }

            public void setRoleNames(String roleNames) {
                this.roleNames = roleNames;
            }
        }
    }
}
