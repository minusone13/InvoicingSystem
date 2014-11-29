package vo;

public enum RM {
		redundance,//重复，一般用于添加一个项目0
		insufficient,//不足，用于商品的销售或赠送
		notfound,//没有找到，用于查找或删除
		unknownerror,//未知错误，需重视
		done,//成功
		treeerror,//商品树错误
		invalid,//不合法，用于验证密码或者ID
		alreadyHaveUnremoveableContents//已有记录或子分类或子商品，不可删除
}
