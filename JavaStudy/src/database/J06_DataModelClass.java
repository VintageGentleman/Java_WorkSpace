package database;

import java.util.ArrayList;
import java.util.List;

import database.quiz.Coffee_A;
import database.quiz.CoffeeDAO_A;

@SuppressWarnings("unused")
public class J06_DataModelClass {

	/*
	  	# 데이터 모델 클래스
	  	
	  	- 데이터를 담아 놓는 용도의 클래스 (DTO, Data Transfer Object)
	  	- 꺼내온 데이터를 매개변수로 활용하거나 제네릭으로 활용하기 위해 사용하는 클래스
	  	- 조회하는 데이터의 형태대로 만들어 둔다
	  	- 필드값의 접근제어자는 private으로 두고
	  	  getter와 setter를 통해 값에 접근해야 한다
	  	- 각 필드에 getter만 달아두면 해당 필드는 읽기 전용이 된다
	  	- setter를 달아 놓으면 수정이 가능한 필드가 된다  
	*/
	
	// (1) 모든 커피를 조회하여 List에 담아서 리턴하는 메서드
	
	// (2) 가격이 3000원 이하인 커피를 조회하여 List에 담아서 리턴하는 메서드
	
	// (3) 새로운 커피를 하나 추가하는 메서드
	//	   (단, 이미 존재하는 커피는 추가할 수 없다)
	
	// (4) 여러개의 커피를 한번에 추가하는 메서드
	//     (단, 이미 존재하는 커피 이름이 있다면 모든 Insert를 취소한다)
		
	// (5) 이미 존재하는 커피의 정보를 수정할 수 있는 메서드를 만들어주세요
	// 	   (ex: 가격만 수정하면 다른 값들은 그대로에 가격만 수정되어야 한다)
	//     (ex: 이름을 수정할 때는 중복되는 이름이 있다면 수정되지 않아야 한다)
	
	public static void main(String[] args) {
		
		CoffeeDAO_A cdao = new CoffeeDAO_A();
		
		// (1)
//		List<Coffee> coffees = cdao.getAllCoffee();
//		System.out.println(coffees);
//	
//		// (2)
//		List<Coffee> chipCoffees = cdao.getCoffee_pricebelow3000();
//		System.out.println(chipCoffees);
//		
		// (3)
//		System.out.println(cdao.addCoffee(new Coffee("Banila latte", 3500)));
		
		// (4)
//		List<Coffee> cafe = new ArrayList<>();
//		
//		cafe.add(new Coffee("chocochip", 3500));
//		cafe.add(new Coffee("latte", 3500));
//		
//		System.out.println(cdao.addAllCoffee(cafe));
		
		// (5)
//		System.out.println(cdao.setName(6, "Banana milk"));
		System.out.println(cdao.setInfo(1, 4000));
		
	}
	
}
