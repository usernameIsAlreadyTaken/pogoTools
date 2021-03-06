package org.pogo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZhouJun
 *	楠岃瘉宸ュ�?�绫�
 */
public class VerifyUtil {

	public VerifyUtil() {
	}

	// -----------------甯�??噺瀹氫箟---------------------//
	/**
	 * Email�?ｅ垯�?�ㄨ�?�寮�^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$
	 */
	public static final String EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

	/**
	 * �?�佃瘽�?�风爜�?ｅ垯�?�ㄨ�?�寮�
	 * (^(\d{2,4}[-_锛�?�]?)?\d{3,8}([-_锛�?�]?\d{3,8})?([-_锛�?�]?\d{1,7})?$)|
	 * (^0?1[35]\d{9}$)
	 */
	public static final String PHONE = "(^(\\d{2,4}[-_锛�?�]?)?\\d{3,8}([-_锛�?�]?\\d{3,8})?([-_锛�?�]?\\d{1,7})?$)|(^0?1[35]\\d{9}$)";

	/**
	 * 鎵嬫満�?�风爜�?ｅ垯�?�ㄨ�?�寮�^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$
	 */
	public static final String MOBILE = "^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\\d{8}$";

	/**
	 * IP�?��?�潃�?ｅ垯�?�ㄨ�?�寮�
	 * ((?:(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\.){3}(?:25[0-5]|2[0-4]\\
	 * d|[01]?\\d?\\d))
	 */
	public static final String IPADDRESS = "((?:(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d))";

	/**
	 * Integer�?ｅ垯�?�ㄨ�?�寮�^-?(([1-9]\d*$)|0)
	 */
	public static final String INTEGER = "^-?(([1-9]\\d*$)|0)";

	/**
	 * �?ｆ暣�??版�?�欒〃�?�惧紡 >=0 ^[1-9]\d*|0$
	 */
	public static final String INTEGER_NEGATIVE = "^[1-9]\\d*|0$";

	/**
	 * �?熸暣�??版�?�欒〃�?�惧紡 <=0 ^-[1-9]\d*|0$
	 */
	public static final String INTEGER_POSITIVE = "^-[1-9]\\d*|0$";

	/**
	 * Double�?ｅ垯�?�ㄨ�?�寮�^-?([1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0)$
	 */
	public static final String DOUBLE = "^-?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0)$";

	/**
	 * �?ouble�?ｅ垯�?�ㄨ�?�寮�>=0 ^[1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0$銆�
	 */
	public static final String DOUBLE_NEGATIVE = "^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0$";

	/**
	 * �?烡ouble�?ｅ垯�?�ㄨ�?�寮�<= 0 ^(-([1-9]\d*\.\d*|0\.\d*[1-9]\d*))|0?\.0+|0$
	 */
	public static final String DOUBLE_POSITIVE = "^(-([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*))|0?\\.0+|0$";

	/**
	 * 骞撮緞�?ｅ垯�?�ㄨ�?�寮�^(?:[1-9][0-9]?|1[01][0-9]|120)$ �?�归厤0-120宀�
	 */
	public static final String AGE = "^(?:[1-9][0-9]?|1[01][0-9]|120)$";

	/**
	 * 閭紪�?ｅ垯�?�ㄨ�?�寮�[1-9]\d{5}(?!\d) �?�藉唴6浣嶉�?�缂�
	 */
	public static final String CODE = "[1-9]\\d{5}(?!\\d)";

	/**
	 * �?�归厤�?�辨暟瀛椼�26涓�?�嫳�?�囧瓧姣嶆垨鑰呬笅�?�掔嚎�?勬垚�?�勫瓧绗︿覆 ^\w+$
	 */
	public static final String STR_ENG_NUM_ = "^\\w+$";

	/**
	 * �?�归厤�?�辨暟瀛楀拰26涓�?�嫳�?�囧瓧姣嶇�?鎴愮殑瀛楃�?涓�^[A-Za-z0-9]+$
	 */
	public static final String STR_ENG_NUM = "^\\w+$";

	/**
	 * �?�归厤�?��6涓�?�嫳�?�囧瓧姣嶇�?鎴愮殑瀛楃�?涓�^[A-Za-z]+$
	 */
	public static final String STR_ENG = "^[A-Za-z]+$";

	/**
	 * �?�归厤涓枃瀛楃�? ^[\u0391-\uFFE5]+$
	 */
	public static final String STR_CHINA = "^[\u0391-\uFFE5]+$";

	/**
	 * �?�囨护�?�规畩瀛楃�?涓�?��?��regEx=
	 * "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~锛丂#锟�鈥︹�&*锛堬級鈥斺�+|{}銆愩�鈥橈紱锛氣�鈥溾�銆傦�?銆侊紵]";
	 */
	public static final String STR_SPECIAL = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~锛丂#锟�鈥︹�&*锛堬級鈥斺�+|{}銆愩�鈥橈紱锛氣�鈥溾�銆傦�?銆侊紵]";

	/**
	 * �?��?�兘�?�撹嫳�?���??�?�瓧 涓枃 ^[a-zA-Z0-9\u4e00-\u9fa5]+$
	 */
	public static final String STR_ENG_CHA_NUM = "^[a-zA-Z0-9\u4e00-\u9fa5]+$";

	/***
	 * �?�ユ湡�?ｅ垯 �?�寔锛�YYYY-MM-DD YYYY/MM/DD YYYY_MM_DD YYYYMMDD YYYY.MM.DD�?�勫舰寮�
	 */
	public static final String DATE_ALL = "((^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._]?)(10|12|0?[13578])([-\\/\\._]?)(3[01]|[12][0-9]|0?[1-9])$)"
			+ "|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._]?)(11|0?[469])([-\\/\\._]?)(30|[12][0-9]|0?[1-9])$)"
			+ "|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._]?)(0?2)([-\\/\\._]?)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\\/\\._]?)(0?2)([-\\/\\._]?)(29)$)|(^([3579][26]00)"
			+ "([-\\/\\._]?)(0?2)([-\\/\\._]?)(29)$)"
			+ "|(^([1][89][0][48])([-\\/\\._]?)(0?2)([-\\/\\._]?)(29)$)|(^([2-9][0-9][0][48])([-\\/\\._]?)"
			+ "(0?2)([-\\/\\._]?)(29)$)"
			+ "|(^([1][89][2468][048])([-\\/\\._]?)(0?2)([-\\/\\._]?)(29)$)|(^([2-9][0-9][2468][048])([-\\/\\._]?)(0?2)"
			+ "([-\\/\\._]?)(29)$)|(^([1][89][13579][26])([-\\/\\._]?)(0?2)([-\\/\\._]?)(29)$)|"
			+ "(^([2-9][0-9][13579][26])([-\\/\\._]?)(0?2)([-\\/\\._]?)(29)$))";
	/***
	 * �?�ユ湡�?ｅ垯 �?�寔锛�YYYY-MM-DD
	 */
	public static final String DATE_FORMAT1 = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";

	// 1.楠岃瘉�?�ユ湡�?�勬�?�欒〃�?�惧紡�?�犲�?�闂�?�勾�?�勫垽�?��?互�?�婃�璺垎�?��
	//
	// �?�涘�?��?ｉ涔嬪墠锛屾垜浠渶瑕佹緞娓呬袱涓�?�蹇碉細
	//
	// 涓��?浠�箞�?�悎娉曠殑�?�ユ湡鑼冨洿锛熷浜�?笉�?�岀殑�?�旂敤�?�烘櫙锛岃繖涓�?�棶棰樻�?涓嶅悓�?�勮В閲娿��?�欓噷閲囩撼MSDN涓殑绾﹀畾锛�
	//
	// DateTime �?�肩被�?�嬭〃绀哄�鑼冨洿�?�ㄥ�?��??冿紙�?�虹潱绾�?�厓锛�001 骞�1 �?��1 �?�ュ�?澶�12:00:00 �?��?��?��??�(C.E.) 9999 骞�12
	// �?��31 �?�ユ櫄涓�11:59:59 涔嬮棿�?�勬棩�?�熷拰�?�堕棿銆�
	//
	// 浜岋�?�??充簬闂�?�勾�?�勯槓閲娿�浜烘皯�??欒�?��?�虹増绀惧皬瀛︽暟瀛﹀�?�勮В閲婃祬�?�庢槗鎳傦紙mediawiki绛�?兘娌¤�?��?负浠�箞�??寸櫨骞翠唤蹇呴�?�?��00�?�勫��??版椂鎵嶆槸闂�?�勾锛夛細
	//
	// �??充簬�??巻闂�?�勾�?��?繖�??疯瀹氱殑锛氬湴�?�冪粫澶�?�槼�??浆涓�懆�?�仛涓�洖褰掑勾锛屼竴�?�炲綊骞撮暱365�?���?��8�?��
	// 46绉掋��?�犳�?锛屽�?��?�嗚瀹氭�?骞冲勾�?�岄棸骞达�?骞冲勾涓�勾�?��65�?�ワ�?姣斿洖褰掑勾�?��.2422�?�ワ�?�?�涘勾�??辩煭0.9688�?�ワ�?�??呮瘡�?�涘勾澧炲姞涓�棩锛岃繖涓�勾�?��66�?�ワ�?�??辨槸闂�?�勾銆備絾�?�涘勾澧炲姞涓�棩姣斿洓涓�?�洖褰掑勾�?��?0.0312�?��400骞�?�悗�??嗗3.12�?���??呭湪400骞翠腑�??戣3涓�?�棸骞�涔熷氨�?�湪400骞翠腑�?��?�97涓�?�棸骞达�?�?��?牱�??巻骞寸殑骞冲潎闀垮害涓庡洖褰掑勾�??辩浉�?�戜技浜�?��?�辨�?瑙勫畾锛氬勾浠芥槸�??寸櫨�??扮殑蹇呴�?�?��00�?�勫��??版墠�?�棸骞达�?渚嬪1900骞淬�2100骞�?�氨涓嶆槸闂�?�勾銆�
	//
	// 娓呮浜嗕互涓�?袱涓�?�蹇碉�?鎴戜滑�?�涘�?��?ｉ銆�
	// 棣栧厛闇�楠岃瘉骞翠唤锛屾樉�?�讹�?骞翠唤鑼冨洿涓�0001 - 9999锛屽尮閰�?YYY�?�勬�?�欒〃�?�惧紡涓猴細
	//
	// [0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3}
	//
	// �??朵腑 [0-9] 涔熷彲浠ヨ〃绀轰负 \d锛屼絾 \d 涓嶅 [0-9] �?�磋�?锛屽洜�?や笅闈㈡垜�??嗕竴�?�撮噰�?��[0-9]
	//
	// �?�ㄦ�?�欒〃�?�惧紡楠岃瘉�?�ユ湡�?�勯毦�??规�?浜岋細涓�槸澶у皬�?�堜唤�?�勫�?��??�?笉�?�岋�?浜屾槸闂�?�勾�?�勮��?戙�
	// 瀵逛簬绗竴涓�?�毦�??癸�?鎴戜滑棣栧厛涓嶈��?戦棸骞达�?�?�囪2�?�堜唤閮芥槸28澶╋�?�?��?牱锛屾湀浠藉拰�?�ユ湡�?�互�?�嗘垚涓夌鎯呭喌锛�
	//
	// 1銆佹湀浠戒负 1, 3, 5, 7, 8, 10, 12锛屽�?��??拌寖�?�翠负 01 - 31锛屽尮閰峂M-DD�?�勬�?�欒〃�?�惧紡涓猴細
	//
	// (0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01])
	//
	// 2銆佹湀浠戒负 4, 6, 9, 11锛屽�?��??拌寖�?�翠负 01-30锛屽尮閰峂M-DD�?�勬�?�欒〃�?�惧紡涓猴細
	//
	// (0[469]|11)-(0[1-9]|[12][0-9]|30)
	//
	// 3銆佹湀浠戒负 2锛岃��?�?钩骞存�?�??碉�?�?�归厤MM-DD�?�勬�?�欒〃�?�惧紡涓猴細
	//
	// 02-(0[1-9]|[1][0-9]|2[0-8])
	//
	// �??规�?涓婇潰�?�勬垚�?��?�?鎴戜滑�?�互寰楀埌�?�归厤骞冲勾�?�ユ湡�??煎紡涓篩YYY-MM-DD�?�勬�?�欒〃�?�惧紡锛�
	//
	// ([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))
	//
	// 鎺ョ潃鎴戜滑�?�ヨВ�??崇浜屼釜闅剧�?�锛氶棸骞寸殑鑰冭檻銆傛牴鎹棸骞寸殑瀹氫箟锛屾垜浠彲浠ュ皢闂�?�勾�?�嗕负涓ょ被锛�
	//
	// 1銆佽兘�?���??撮櫎浣嗕笉鑳借100�??撮櫎�?�勫勾浠�?�瀵绘壘�?��?袱浣嶇殑�?�樺寲瑙勫緥锛屽彲浠ュ緢蹇緱�?��?笅闈㈢殑�?ｅ垯�?�归厤锛�
	//
	// ([0-9]{2})(0[48]|[2468][048]|[13579][26])
	//
	// 2銆佽兘�?��00�??撮櫎�?�勫勾浠�?�鑳借400�??撮櫎�?�勬暟鑲畾鑳借100�??撮櫎锛屽洜�?ゅ悗涓や綅鑲畾�?��0锛屾垜浠彧瑕佷繚璇佸墠涓や綅鑳借4�??撮櫎�?�冲彲锛岀浉�?�旂殑�?ｅ垯�?�ㄨ�?�寮忎负锛�
	//
	// (0[48]|[2468][048]|[3579][26])00
	//
	// 2.�?��己楠岃瘉�?�ユ湡�?�勬�?�欒〃�?�惧紡,娣诲姞浜嗛棸骞寸殑楠岃瘉
	//
	// �?�欎釜�?�ユ湡�?ｅ垯�?�ㄨ�?�寮忔敮鎸�
	// YYYY-MM-DD
	// YYYY/MM/DD
	// YYYY_MM_DD
	// YYYY.MM.DD�?�勫舰寮�
	//
	// match : 2008-2-29 2008/02/29
	//
	// not match : 2008-2-30 2007-2-29
	//
	// 瀹屾暣�?�勬�?�欒〃�?�惧紡濡備笅:
	// ((^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(10|12|0?[13578])([-\/\._])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(11|0?[469])([-\/\._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(0?2)([-\/\._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\/\._])(0?2)([-\/\._])(29)$)|(^([3579][26]00)([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][0][48])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][0][48])([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][2468][048])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][2468][048])([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][13579][26])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][13579][26])([-\/\._])(0?2)([-\/\._])(29)$))
	// 闂�?�勾�?���?�堜唤�?��9澶╋�?�?�犳�?�?�归厤闂�?�勾�?�ユ湡�??煎紡涓篩YYY-MM-DD�?�勬�?�欒〃�?�惧紡涓猴細
	//
	// (([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29
	//
	// �?��悗锛屽皢骞冲勾�?�岄棸骞寸殑�?�ユ湡楠岃瘉�?�ㄨ�?�寮忓悎骞讹�?鎴戜滑寰楀埌�?��粓�?�勯�?�璇佹棩�?�熸牸寮忎负YYYY-MM-DD�?�勬�?�欒〃�?�惧紡涓猴細
	//
	// (([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)
	//
	// DD/MM/YYYY�??煎紡�?�勬�?�欓�?�璇佽〃�?�惧紡涓猴細
	//
	// (((0[1-9]|[12][0-9]|3[01])/((0[13578]|1[02]))|((0[1-9]|[12][0-9]|30)/(0[469]|11))|(0[1-9]|[1][0-9]|2[0-8])/(02))/([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3}))|(29/02/(([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00)))

	/**
	 * URL�?ｅ垯�?�ㄨ�?�寮��?�归厤 http www ftp
	 */
	public static final String URL = "^(http|www|ftp|)?(://)?(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*((:\\d+)?)(/(\\w+(-\\w+)*))*(\\.?(\\w)*)(\\?)?"
			+ "(((\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*(\\w*%)*(\\w*\\?)*"
			+ "(\\w*:)*(\\w*\\+)*(\\w*\\.)*"
			+ "(\\w*&)*(\\w*-)*(\\w*=)*)*(\\w*)*)$";

	/**
	 * 韬唤璇佹�?�欒〃�?�惧紡
	 */
	public static final String IDCARD = "((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65)[0-9]{4})"
			+ "(([1|2][0-9]{3}[0|1][0-9][0-3][0-9][0-9]{3}"
			+ "[Xx0-9])|([0-9]{2}[0|1][0-9][0-3][0-9][0-9]{3}))";

	/**
	 * 1.�?�归厤绉�?�?℃暟 e鎴栬�E蹇呴�?�?�虹幇�?�変笖�?��?��?涓� 涓嶅惈Dd �?ｅ垯
	 * ^[-+]?(\d+(\.\d*)?|\.\d+)([eE]([-+]?([012]
	 * ?\d{1,2}|30[0-7])|-3([01]?[4-9]|[012]?[0-3])))$
	 */
	public final static String SCIENTIFIC_A = "^[-+]?(\\d+(\\.\\d*)?|\\.\\d+)([eE]([-+]?([012]?\\d{1,2}|30[0-7])|-3([01]?[4-9]|[012]?[0-3])))$";

	/**
	 * 2.�?�归厤绉�?�?℃暟 e鎴栬�E蹇呴�?�?�虹幇�?�変笖�?��?��?涓� �?撳熬�?�呭惈Dd �?ｅ垯
	 * ^[-+]?(\d+(\.\d*)?|\.\d+)([eE]([-+]?([012
	 * ]?\d{1,2}|30[0-7])|-3([01]?[4-9]|[012]?[0-3])))[dD]?$
	 */
	public final static String SCIENTIFIC_B = "^[-+]?(\\d+(\\.\\d*)?|\\.\\d+)([eE]([-+]?([012]?\\d{1,2}|30[0-7])|-3([01]?[4-9]|[012]?[0-3])))[dD]?$";

	/**
	 * 3.�?�归厤绉�?�?℃暟 �?��?�?��?E鎴栬�e閮介��?���?撳熬�?��?Dd�?�勪篃閫氳繃锛堥拡瀵笵ouble绫诲瀷锛��?ｅ垯
	 * ^[-+]?(\d+(\.\d*)?|\.\d+)([
	 * eE]([-+]?([012]?\d{1,2}|30[0-7])|-3([01]?[4-9]|[012]?[0-3])))?[dD]?$
	 */
	public final static String SCIENTIFIC_C = "^[-+]?(\\d+(\\.\\d*)?|\\.\\d+)([eE]([-+]?([012]?\\d{1,2}|30[0-7])|-3([01]?[4-9]|[012]?[0-3])))?[dD]?$";

	/**
	 * 4.�?�归厤绉�?�?℃暟 �?��?�?��?E鎴栬�e閮介��?���?撳熬涓嶅惈Dd �?ｅ垯
	 * ^[-+]?(\d+(\.\d*)?|\.\d+)([eE]([-+]?([012]?
	 * \d{1,2}|30[0-7])|-3([01]?[4-9]|[012]?[0-3])))?$
	 */
	public final static String SCIENTIFIC_D = "^[-+]?(\\d+(\\.\\d*)?|\\.\\d+)([eE]([-+]?([012]?\\d{1,2}|30[0-7])|-3([01]?[4-9]|[012]?[0-3])))?$";

	/**
	 * �?�ゆ柇瀛�?�?��?涓虹┖ 绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static synchronized boolean StrisNull(String str) {
		return null == str || str.trim().length() <= 0 ? true : false;
	}

	/**
	 * �?�ゆ柇瀛�?�?�潪绌�绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean StrNotNull(String str) {
		return !StrisNull(str);
	}

	/**
	 * 瀛楃�?涓瞡ull�?�┖
	 * 
	 * @param str
	 * @return boolean
	 */
	public static String nulltoStr(String str) {
		return StrisNull(str) ? "" : str;
	}

	/**
	 * 瀛楃�?涓瞡ull璧嬪�榛樿�?��
	 * 
	 * @param str
	 *            �?�爣瀛楃�?涓�
	 * @param defaut
	 *            榛樿�?��
	 * @return String
	 */
	public static String nulltoStr(String str, String defaut) {
		return StrisNull(str) ? defaut : str;
	}

	/**
	 * �?�ゆ柇瀛�?�?��?涓�?mail 绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmail(String str) {
		return Regular(str, EMAIL);
	}

	/**
	 * �?�ゆ柇�?��?涓虹數璇濆彿�?��绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isPhone(String str) {
		return Regular(str, PHONE);
	}

	/**
	 * �?�ゆ柇�?��?涓烘墜�?�哄彿�?��绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isMobile(String str) {
		return Regular(str, MOBILE);
	}

	/**
	 * �?�ゆ柇�?��?涓篣rl 绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isUrl(String str) {
		return Regular(str, URL);
	}

	/**
	 * �?�ゆ柇�?��?涓篒P�?��?�潃 绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isIpaddress(String str) {
		return Regular(str, IPADDRESS);
	}

	/**
	 * �?�ゆ柇瀛�?�?��?涓烘暟瀛��?ｈ礋�??存暟 �?ｈ礋娴�?��??�绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isNumber(String str) {
		return Regular(str, DOUBLE);
	}

	/**
	 * �?�ゆ柇瀛�?�?��?涓篒NTEGER 绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isInteger(String str) {
		return Regular(str, INTEGER);
	}

	/**
	 * 
	 * �?�ゆ柇瀛�?�?��?涓烘�??存暟�?ｅ垯�?�ㄨ�?�寮�>=0 绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isINTEGER_NEGATIVE(String str) {
		return Regular(str, INTEGER_NEGATIVE);
	}

	/**
	 * �?�ゆ柇瀛�?�?��?涓鸿礋�??存暟�?ｅ垯�?�ㄨ�?�寮�<=0 绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isINTEGER_POSITIVE(String str) {
		return Regular(str, INTEGER_POSITIVE);
	}

	/**
	 * �?�ゆ柇瀛�?�?��?涓篋OUBLE 绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isDouble(String str) {
		return Regular(str, DOUBLE);
	}

	/**
	 * �?�ゆ柇瀛�?�?��?涓烘娴�?��??版�?�欒〃�?�惧紡 >=0 绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isDOUBLE_NEGATIVE(String str) {
		return Regular(str, DOUBLE_NEGATIVE);
	}

	/**
	 * �?�ゆ柇瀛�?�?��?涓鸿礋娴�?��??版�?�欒〃�?�惧紡 <=0 绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isDOUBLE_POSITIVE(String str) {
		return Regular(str, DOUBLE_POSITIVE);
	}

	/**
	 * �?�ゆ柇瀛�?�?��?涓烘棩�?��绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isDate(String str) {
		return Regular(str, DATE_ALL);
	}

	/**
	 * 楠岃瘉2010-12-10
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDate1(String str) {
		return Regular(str, DATE_FORMAT1);
	}

	/**
	 * �?�ゆ柇瀛�?�?��?涓哄勾榫�绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isAge(String str) {
		return Regular(str, AGE);
	}

	/**
	 * �?�ゆ柇瀛�?�?��?瓒呴暱 瀛椾覆涓虹┖�?�斿洖fasle, 瓒呰繃闀垮害{leng}�?�斿洖ture �?�嶄箣�?�斿洖false
	 * 
	 * @param str
	 * @param leng
	 * @return boolean
	 */
	public static boolean isLengOut(String str, int leng) {
		return StrisNull(str) ? false : str.trim().length() > leng;
	}

	/**
	 * �?�ゆ柇瀛�?�?��?瓒呴暱, 瓒呰繃闀垮害{leng}�?�斿洖ture �?�嶄箣�?�斿洖false
	 * 
	 * @param str
	 * @param leng
	 * @return boolean
	 */
	public static boolean isLengOver(String str, int leng) {
		if(str.trim().length() <= leng) {
			return true;
		}
		return false;
	}
	
	/**
	 * �?�ゆ柇瀛�?�?��?涓鸿韩浠借瘉 绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isIdCard(String str) {
		if (StrisNull(str))
			return false;
		if (str.trim().length() == 15 || str.trim().length() == 18) {
			return Regular(str, IDCARD);
		} else {
			return false;
		}
	}

	/**
	 * �?�ゆ柇瀛�?�?��?涓洪�?�缂�绗﹀悎�?�斿洖ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isCode(String str) {
		return Regular(str, CODE);
	}

	/**
	 * �?�ゆ柇瀛楃�?涓�?�槸涓嶆槸�??ㄩ儴�?�眽瀛�
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isChina(String str) {
		return Regular(str, STR_CHINA);
	}

	/**
	 * �?�ゆ柇瀛楃�?涓�?�槸涓嶆槸�??ㄩ儴�?��?嫳�?�囧瓧姣�
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isEnglish(String str) {
		return Regular(str, STR_ENG);
	}

	/**
	 * �?�ゆ柇瀛楃�?涓�?�槸涓嶆槸�??ㄩ儴�?��?嫳�?�囧瓧姣��??�?�瓧
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isENG_NUM(String str) {
		return Regular(str, STR_ENG_NUM);
	}

	/**
	 * �?�ゆ柇瀛楃�?涓�?�槸涓嶆槸�??ㄩ儴�?��?嫳�?�囧瓧姣��??�?�瓧+涓嬪�?绾�
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isENG_NUM_(String str) {
		return Regular(str, STR_ENG_NUM_);
	}

	/**
	 * �?�囨护�?�规畩瀛楃�?涓��?�斿洖�?�囨护�?�庣殑瀛楃�?涓�
	 * 
	 * @param str
	 * @return boolean
	 */
	public static String filterStr(String str) {
		Pattern p = Pattern.compile(STR_SPECIAL);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	/**
	 * �?�归厤�?��?绗﹀悎�?ｅ垯�?�ㄨ�?�寮�?attern �?�归厤�?�斿洖true
	 * 
	 * @param str
	 *            �?�归厤�?�勫瓧绗︿覆
	 * @param pattern
	 *            �?�归厤妯″紡
	 * @return boolean
	 */
	private static boolean Regular(String str, String pattern) {
		if (null == str || str.trim().length() <= 0)
			return false;
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	/**
	 * �?�ゆ柇�?�笉�?��?瀛�?�??版硶 濡傛�?��?���?�斿洖true �?�归厤绉�?�?℃暟 e鎴栬�E蹇呴�?�?�虹幇�?�変笖�?��?��?涓� �?撳熬涓嶅惈D �?�归厤妯″紡�?�弬鑰冩湰绫诲畾涔夌殑
	 * SCIENTIFIC_A锛孲CIENTIFIC_B,SCIENTIFIC_C,SCIENTIFIC_D 鑻ュ垽�?��?负�??朵粬妯″紡�?��?皟�?��
	 * Regular(String str,String pattern)�?�规硶
	 * 
	 * @param str
	 *            绉�?�?℃暟瀛楃�?涓�
	 * @return boolean
	 */
	public static boolean isScientific(String str) {
		if (StrisNull(str))
			return false;
		return Regular(str, VerifyUtil.SCIENTIFIC_A);
	}
}
