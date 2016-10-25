package io.swagger.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.muran.mrshop.api.WxRes;

import java.lang.reflect.Type;
import java.util.List;
import io.swagger.client.model.*;
import io.swagger.client.model.Error;

public class JsonUtil {
  public static GsonBuilder gsonBuilder;

  static {
    gsonBuilder = new GsonBuilder();
    gsonBuilder.serializeNulls();
    gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
  }

  public static Gson getGson() {
    return gsonBuilder.create();
  }

  public static String serialize(Object obj){
    return getGson().toJson(obj);
  }

  public static <T> T deserializeToList(String jsonString, Class cls){
    return getGson().fromJson(jsonString, getListTypeForDeserialization(cls));
  }

  public static <T> T deserializeToObject(String jsonString, Class cls){
    return getGson().fromJson(jsonString, getTypeForDeserialization(cls));
  }

  public static Type getListTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();

    if ("AddAdmin".equalsIgnoreCase(className)) {
      return new TypeToken<List<AddAdmin>>(){}.getType();
    }

    if ("AdminInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<AdminInfo>>(){}.getType();
    }
    if ("WechatLoginInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<WechatLoginInfo>>(){}.getType();
    }
    if ("WxAppPay".equalsIgnoreCase(className)) {
      return new TypeToken<List<WxAppPay>>(){}.getType();
    }
    if ("WxPay".equalsIgnoreCase(className)) {
      return new TypeToken<List<WxPay>>(){}.getType();
    }
    if ("Area".equalsIgnoreCase(className)) {
      return new TypeToken<List<Area>>(){}.getType();
    }

    if ("FileInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<FileInfo>>(){}.getType();
    }

    if ("GeneralString".equalsIgnoreCase(className)) {
      return new TypeToken<List<GeneralString>>(){}.getType();
    }

    if ("UploadFileToken".equalsIgnoreCase(className)) {
      return new TypeToken<List<UploadFileToken>>(){}.getType();
    }

    if ("AccountStat".equalsIgnoreCase(className)) {
      return new TypeToken<List<AccountStat>>(){}.getType();
    }

    if ("BillInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<BillInfo>>(){}.getType();
    }

    if ("BillInfoPageData".equalsIgnoreCase(className)) {
      return new TypeToken<List<BillInfoPageData>>(){}.getType();
    }

    if ("GeneralNumber".equalsIgnoreCase(className)) {
      return new TypeToken<List<GeneralNumber>>(){}.getType();
    }

    if ("GeneralString".equalsIgnoreCase(className)) {
      return new TypeToken<List<GeneralString>>(){}.getType();
    }

    if ("PrePaidCard".equalsIgnoreCase(className)) {
      return new TypeToken<List<PrePaidCard>>(){}.getType();
    }

    if ("PrePaidCardCreateRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<PrePaidCardCreateRecord>>(){}.getType();
    }

    if ("PrePaidCardCreateRecordPageData".equalsIgnoreCase(className)) {
      return new TypeToken<List<PrePaidCardCreateRecordPageData>>(){}.getType();
    }

    if ("PrePaidCardPageData".equalsIgnoreCase(className)) {
      return new TypeToken<List<PrePaidCardPageData>>(){}.getType();
    }

    if ("UserAccountInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserAccountInfo>>(){}.getType();
    }

    if ("UserBillInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserBillInfo>>(){}.getType();
    }

    if ("AgentInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<AgentInfo>>(){}.getType();
    }
    
    if ("BindReturn".equalsIgnoreCase(className)) {
      return new TypeToken<List<BindReturn>>(){}.getType();
    }
    
    if ("Error".equalsIgnoreCase(className)) {
      return new TypeToken<List<Error>>(){}.getType();
    }
    
    if ("GeneralString".equalsIgnoreCase(className)) {
      return new TypeToken<List<GeneralString>>(){}.getType();
    }
    
    if ("GradeInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<GradeInfo>>(){}.getType();
    }
    
    if ("InviteRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<InviteRecord>>(){}.getType();
    }
    
    if ("PersonInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<PersonInfo>>(){}.getType();
    }
    
    if ("RelationInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<RelationInfo>>(){}.getType();
    }
    
    if ("UserInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserInfo>>(){}.getType();
    }
    
    if ("UserPageData".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserPageData>>(){}.getType();
    }
    
    if ("UserUnionInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserUnionInfo>>(){}.getType();
    }
    
    if ("WxConfig".equalsIgnoreCase(className)) {
      return new TypeToken<List<WxConfig>>(){}.getType();
    }
    if ("AddVIPRPInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<AddVIPRPInfo>>(){}.getType();
    }

    if ("Error".equalsIgnoreCase(className)) {
      return new TypeToken<List<Error>>(){}.getType();
    }

    if ("GeneralNumber".equalsIgnoreCase(className)) {
      return new TypeToken<List<GeneralNumber>>(){}.getType();
    }

    if ("GeneralString".equalsIgnoreCase(className)) {
      return new TypeToken<List<GeneralString>>(){}.getType();
    }

    if ("GradeDes".equalsIgnoreCase(className)) {
      return new TypeToken<List<GradeDes>>(){}.getType();
    }

    if ("NameValue".equalsIgnoreCase(className)) {
      return new TypeToken<List<NameValue>>(){}.getType();
    }

    if ("RPCheckInSetting".equalsIgnoreCase(className)) {
      return new TypeToken<List<RPCheckInSetting>>(){}.getType();
    }

    if ("RPInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<RPInfo>>(){}.getType();
    }

    if ("RPOpenRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<RPOpenRecord>>(){}.getType();
    }

    if ("RPRank".equalsIgnoreCase(className)) {
      return new TypeToken<List<RPRank>>(){}.getType();
    }

    if ("RPSetting".equalsIgnoreCase(className)) {
      return new TypeToken<List<RPSetting>>(){}.getType();
    }

    if ("VIPRPInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<VIPRPInfo>>(){}.getType();
    }

    if ("VIPRPPageData".equalsIgnoreCase(className)) {
      return new TypeToken<List<VIPRPPageData>>(){}.getType();
    }
    if ("AddComment".equalsIgnoreCase(className)) {
      return new TypeToken<List<AddComment>>(){}.getType();
    }

    if ("AddGoodsOrder".equalsIgnoreCase(className)) {
      return new TypeToken<List<AddGoodsOrder>>(){}.getType();
    }

    if ("AddOrUpdateGoodsCategory".equalsIgnoreCase(className)) {
      return new TypeToken<List<AddOrUpdateGoodsCategory>>(){}.getType();
    }

    if ("AddOrUpdateGoodsInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<AddOrUpdateGoodsInfo>>(){}.getType();
    }

    if ("AddOrUpdateGoodsReq".equalsIgnoreCase(className)) {
      return new TypeToken<List<AddOrUpdateGoodsReq>>(){}.getType();
    }

    if ("AddOrUpdateShippingAddress".equalsIgnoreCase(className)) {
      return new TypeToken<List<AddOrUpdateShippingAddress>>(){}.getType();
    }

    if ("AdminGoodsOrder".equalsIgnoreCase(className)) {
      return new TypeToken<List<AdminGoodsOrder>>(){}.getType();
    }

    if ("AdminGoodsOrderPageData".equalsIgnoreCase(className)) {
      return new TypeToken<List<AdminGoodsOrderPageData>>(){}.getType();
    }

    if ("AppGoodsOrder".equalsIgnoreCase(className)) {
      return new TypeToken<List<AppGoodsOrder>>(){}.getType();
    }

    if ("Comment".equalsIgnoreCase(className)) {
      return new TypeToken<List<Comment>>(){}.getType();
    }

    if ("CommentPageData".equalsIgnoreCase(className)) {
      return new TypeToken<List<CommentPageData>>(){}.getType();
    }

    if ("GeneralString".equalsIgnoreCase(className)) {
      return new TypeToken<List<GeneralString>>(){}.getType();
    }

    if ("GoodsCategory".equalsIgnoreCase(className)) {
      return new TypeToken<List<GoodsCategory>>(){}.getType();
    }

    if ("GoodsCategoryPageData".equalsIgnoreCase(className)) {
      return new TypeToken<List<GoodsCategoryPageData>>(){}.getType();
    }

    if ("GoodsInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<GoodsInfo>>(){}.getType();
    }

    if ("GoodsPageData".equalsIgnoreCase(className)) {
      return new TypeToken<List<GoodsPageData>>(){}.getType();
    }

    if ("GoodsReq".equalsIgnoreCase(className)) {
      return new TypeToken<List<GoodsReq>>(){}.getType();
    }

    if ("KeyValue".equalsIgnoreCase(className)) {
      return new TypeToken<List<KeyValue>>(){}.getType();
    }

    if ("OrderActionRecord".equalsIgnoreCase(className)) {
      return new TypeToken<List<OrderActionRecord>>(){}.getType();
    }

    if ("ShInfoSettingVersion".equalsIgnoreCase(className)) {
      return new TypeToken<List<ShInfoSettingVersion>>(){}.getType();
    }

    if ("ShippingAddress".equalsIgnoreCase(className)) {
      return new TypeToken<List<ShippingAddress>>(){}.getType();
    }

    if ("SimpleAdminGoodsOrder".equalsIgnoreCase(className)) {
      return new TypeToken<List<SimpleAdminGoodsOrder>>(){}.getType();
    }

    if ("SimpleAppGoodsOrder".equalsIgnoreCase(className)) {
      return new TypeToken<List<SimpleAppGoodsOrder>>(){}.getType();
    }

    if ("SimpleGoodsInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<SimpleGoodsInfo>>(){}.getType();
    }
    if ("SmsResultInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<SmsResultInfo>>(){}.getType();
    }
    return new TypeToken<List<Object>>(){}.getType();
  }

  //商城list 序列化
  private static Type shListForDeserialization(String className){

    return new TypeToken<List<Object>>(){}.getType();
  }


  public static Type getTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();
    if ("SmsResultInfo".equalsIgnoreCase(className)) {
      return new TypeToken<SmsResultInfo>(){}.getType();
    }
    if ("WxAppPay".equalsIgnoreCase(className)) {
      return new TypeToken<WxAppPay>(){}.getType();
    }
    if ("WxPay".equalsIgnoreCase(className)) {
      return new TypeToken<WxPay>(){}.getType();
    }

    if ("AddComment".equalsIgnoreCase(className)) {
      return new TypeToken<AddComment>(){}.getType();
    }

    if ("AddGoodsOrder".equalsIgnoreCase(className)) {
      return new TypeToken<AddGoodsOrder>(){}.getType();
    }

    if ("AddOrUpdateGoodsCategory".equalsIgnoreCase(className)) {
      return new TypeToken<AddOrUpdateGoodsCategory>(){}.getType();
    }

    if ("AddOrUpdateGoodsInfo".equalsIgnoreCase(className)) {
      return new TypeToken<AddOrUpdateGoodsInfo>(){}.getType();
    }

    if ("AddOrUpdateGoodsReq".equalsIgnoreCase(className)) {
      return new TypeToken<AddOrUpdateGoodsReq>(){}.getType();
    }

    if ("AddOrUpdateShippingAddress".equalsIgnoreCase(className)) {
      return new TypeToken<AddOrUpdateShippingAddress>(){}.getType();
    }

    if ("AdminGoodsOrder".equalsIgnoreCase(className)) {
      return new TypeToken<AdminGoodsOrder>(){}.getType();
    }

    if ("AdminGoodsOrderPageData".equalsIgnoreCase(className)) {
      return new TypeToken<AdminGoodsOrderPageData>(){}.getType();
    }

    if ("AppGoodsOrder".equalsIgnoreCase(className)) {
      return new TypeToken<AppGoodsOrder>(){}.getType();
    }

    if ("Comment".equalsIgnoreCase(className)) {
      return new TypeToken<Comment>(){}.getType();
    }

    if ("CommentPageData".equalsIgnoreCase(className)) {
      return new TypeToken<CommentPageData>(){}.getType();
    }

    if ("GeneralString".equalsIgnoreCase(className)) {
      return new TypeToken<GeneralString>(){}.getType();
    }

    if ("GoodsCategory".equalsIgnoreCase(className)) {
      return new TypeToken<GoodsCategory>(){}.getType();
    }

    if ("GoodsCategoryPageData".equalsIgnoreCase(className)) {
      return new TypeToken<GoodsCategoryPageData>(){}.getType();
    }

    if ("GoodsInfo".equalsIgnoreCase(className)) {
      return new TypeToken<GoodsInfo>(){}.getType();
    }

    if ("GoodsPageData".equalsIgnoreCase(className)) {
      return new TypeToken<GoodsPageData>(){}.getType();
    }

    if ("GoodsReq".equalsIgnoreCase(className)) {
      return new TypeToken<GoodsReq>(){}.getType();
    }

    if ("KeyValue".equalsIgnoreCase(className)) {
      return new TypeToken<KeyValue>(){}.getType();
    }

    if ("OrderActionRecord".equalsIgnoreCase(className)) {
      return new TypeToken<OrderActionRecord>(){}.getType();
    }

    if ("ShInfoSettingVersion".equalsIgnoreCase(className)) {
      return new TypeToken<ShInfoSettingVersion>(){}.getType();
    }

    if ("ShippingAddress".equalsIgnoreCase(className)) {
      return new TypeToken<ShippingAddress>(){}.getType();
    }

    if ("SimpleAdminGoodsOrder".equalsIgnoreCase(className)) {
      return new TypeToken<SimpleAdminGoodsOrder>(){}.getType();
    }

    if ("SimpleAppGoodsOrder".equalsIgnoreCase(className)) {
      return new TypeToken<SimpleAppGoodsOrder>(){}.getType();
    }

    if ("SimpleGoodsInfo".equalsIgnoreCase(className)) {
      return new TypeToken<SimpleGoodsInfo>(){}.getType();
    }

    if ("Area".equalsIgnoreCase(className)) {
      return new TypeToken<Area>(){}.getType();
    }

    if ("FileInfo".equalsIgnoreCase(className)) {
      return new TypeToken<FileInfo>(){}.getType();
    }

    if ("UploadFileToken".equalsIgnoreCase(className)) {
      return new TypeToken<UploadFileToken>(){}.getType();
    }


    if ("AccountStat".equalsIgnoreCase(className)) {
      return new TypeToken<AccountStat>(){}.getType();
    }

    if ("BillInfo".equalsIgnoreCase(className)) {
      return new TypeToken<BillInfo>(){}.getType();
    }

    if ("BillInfoPageData".equalsIgnoreCase(className)) {
      return new TypeToken<BillInfoPageData>(){}.getType();
    }

    if ("GeneralNumber".equalsIgnoreCase(className)) {
      return new TypeToken<GeneralNumber>(){}.getType();
    }

    if ("GeneralString".equalsIgnoreCase(className)) {
      return new TypeToken<GeneralString>(){}.getType();
    }

    if ("PrePaidCard".equalsIgnoreCase(className)) {
      return new TypeToken<PrePaidCard>(){}.getType();
    }

    if ("PrePaidCardCreateRecord".equalsIgnoreCase(className)) {
      return new TypeToken<PrePaidCardCreateRecord>(){}.getType();
    }

    if ("PrePaidCardCreateRecordPageData".equalsIgnoreCase(className)) {
      return new TypeToken<PrePaidCardCreateRecordPageData>(){}.getType();
    }

    if ("PrePaidCardPageData".equalsIgnoreCase(className)) {
      return new TypeToken<PrePaidCardPageData>(){}.getType();
    }

    if ("UserAccountInfo".equalsIgnoreCase(className)) {
      return new TypeToken<UserAccountInfo>(){}.getType();
    }

    if ("UserBillInfo".equalsIgnoreCase(className)) {
      return new TypeToken<UserBillInfo>(){}.getType();
    }
    if ("AgentInfo".equalsIgnoreCase(className)) {
      return new TypeToken<AgentInfo>(){}.getType();
    }
    
    if ("BindReturn".equalsIgnoreCase(className)) {
      return new TypeToken<BindReturn>(){}.getType();
    }
    
    if ("Error".equalsIgnoreCase(className)) {
      return new TypeToken<Error>(){}.getType();
    }
    
    if ("GeneralString".equalsIgnoreCase(className)) {
      return new TypeToken<GeneralString>(){}.getType();
    }
    
    if ("GradeInfo".equalsIgnoreCase(className)) {
      return new TypeToken<GradeInfo>(){}.getType();
    }
    
    if ("InviteRecord".equalsIgnoreCase(className)) {
      return new TypeToken<InviteRecord>(){}.getType();
    }
    
    if ("PersonInfo".equalsIgnoreCase(className)) {
      return new TypeToken<PersonInfo>(){}.getType();
    }
    
    if ("RelationInfo".equalsIgnoreCase(className)) {
      return new TypeToken<RelationInfo>(){}.getType();
    }
    
    if ("UserInfo".equalsIgnoreCase(className)) {
      return new TypeToken<UserInfo>(){}.getType();
    }
    
    if ("UserPageData".equalsIgnoreCase(className)) {
      return new TypeToken<UserPageData>(){}.getType();
    }
    
    if ("UserUnionInfo".equalsIgnoreCase(className)) {
      return new TypeToken<UserUnionInfo>(){}.getType();
    }
    
    if ("WxConfig".equalsIgnoreCase(className)) {
      return new TypeToken<WxConfig>(){}.getType();
    }
    if ("WxRes".equalsIgnoreCase(className)) {
      return new TypeToken<WxRes>(){}.getType();
    }
    if ("AddVIPRPInfo".equalsIgnoreCase(className)) {
      return new TypeToken<AddVIPRPInfo>(){}.getType();
    }

    if ("Error".equalsIgnoreCase(className)) {
      return new TypeToken<Error>(){}.getType();
    }

    if ("GeneralNumber".equalsIgnoreCase(className)) {
      return new TypeToken<GeneralNumber>(){}.getType();
    }

    if ("GeneralString".equalsIgnoreCase(className)) {
      return new TypeToken<GeneralString>(){}.getType();
    }

    if ("GradeDes".equalsIgnoreCase(className)) {
      return new TypeToken<GradeDes>(){}.getType();
    }

    if ("NameValue".equalsIgnoreCase(className)) {
      return new TypeToken<NameValue>(){}.getType();
    }

    if ("RPCheckInSetting".equalsIgnoreCase(className)) {
      return new TypeToken<RPCheckInSetting>(){}.getType();
    }

    if ("RPInfo".equalsIgnoreCase(className)) {
      return new TypeToken<RPInfo>(){}.getType();
    }

    if ("RPOpenRecord".equalsIgnoreCase(className)) {
      return new TypeToken<RPOpenRecord>(){}.getType();
    }

    if ("RPRank".equalsIgnoreCase(className)) {
      return new TypeToken<RPRank>(){}.getType();
    }

    if ("RPSetting".equalsIgnoreCase(className)) {
      return new TypeToken<RPSetting>(){}.getType();
    }

    if ("VIPRPInfo".equalsIgnoreCase(className)) {
      return new TypeToken<VIPRPInfo>(){}.getType();
    }

    if ("VIPRPPageData".equalsIgnoreCase(className)) {
      return new TypeToken<VIPRPPageData>(){}.getType();
    }
    if ("AddAdmin".equalsIgnoreCase(className)) {
      return new TypeToken<AddAdmin>(){}.getType();
    }

    if ("AdminInfo".equalsIgnoreCase(className)) {
      return new TypeToken<AdminInfo>(){}.getType();
    }
    if ("WechatLoginInfo".equalsIgnoreCase(className)) {
      return new TypeToken<WechatLoginInfo>(){}.getType();
    }

    return new TypeToken<Object>(){}.getType();
  }

  //商城type 序列化
  private static Type shTypeForDeserialization(String className){

    return new TypeToken<Object>(){}.getType();
  }
};
