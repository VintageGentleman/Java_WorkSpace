# 팀프로젝트(KIOSK 제작)

##### 프로젝트 목적

 메가커피 키오스크를 바탕으로 시중에 있는 키오스크 프로그램 구현.

##### 구동시 주의사항
 
💬 DB 테이블 폴더에 있는 데이터 테이블 설정을 로컬호스트 내에 먼저 구성한다. <br>
💬 database.OjdbcConnection 클래스 내의 멤버변수를 본인의 DB 설정에 맞춘다. <br>
💬 Main클래스는 project 패키지 내의 Execution 클래스이다. <br>

## 팀 소개
```javascript 
/** Introduction of ReturnMinus1 */  
public class TeamReturnMinus1 {
	// github_id
	String crew_AmuGeoNaHae;
	String crew_Leekmkm;
	String crew_VintageGentleman;
	String crew_Bgicheol;
	
	public Project createProject(String[] crews) {
		return KioskProject;
	}
}
``` 
## 개발환경🛠️
| [<img src="https://i.namu.wiki/i/SYrBI_p_biVutwbD1BAgay_FQMbcUHSvomKVjKnhZiIc0i_BlCRiYyPN0aB8Ye8aoD5S4YQaXy8o5YvA8nHa1ppT408YHFz0U3LmH8ZQUmD--npomEE5Ex4vhEH5DHXNQ7nmfanMyaoUKJ6QZK3niQ.svg" alt="Java" width="30">](https://www.oracle.com/) |  [<img src="https://mpng.subpng.com/20180509/jpw/kisspng-swing-graphical-user-interface-javafx-java-foundat-5af37e6e6700f8.6663967215259070544219.jpg" alt="swing" width="30">](https:///www.oracle.com/) | [<img src="https://raw.githubusercontent.com/github/explore/80688e429a7d4ef2fca1e82350fe8e3517d3494d/topics/git/git.png" alt="Git" width="30">](https://git-scm.com/) |  [<img src="https://www.eclipse.org/downloads/assets/public/images/logo-eclipse.png" width="30">](https://www.eclipse.org/) | [<img src="https://i.namu.wiki/i/RG9FxI230sOdulAeM6NgoU8pro9a27mCR9ZnkCtTVaAW0xdE59ewXvDXlFPj9BneL9xHshhiGizHd38W3_TbQmElm1x3HnIc5jow_JVQKVL1qVXQOoB-qkUsFQAKq_rzc3kKLDD4uK4BwUCM1B4vzA.webp" alt="oracle DB" width="60">](https://www.oracle.com/) | [<img src="data:image/png;base64,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" width="30">](https://github.com/)  |
|---|---|---|---|---|---|

## 실제구현 모습
![관리자모드 흐름](.\images\Example_Images\ManagerFlow.gif '관리자모드 흐름')
![결제 흐름](.\images\Example_Images\PaymentFlow.gif '결제 흐름')


