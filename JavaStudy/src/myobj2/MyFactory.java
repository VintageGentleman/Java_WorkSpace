package myobj2;

// 반드시 T로 할 필요없다. 예를 들어 Babo로 타입명을 정해도 상관없다.
// 같은 타입끼리 이름만 똑같으면 된다.
// 일반적으로 Type을 의미하는 T를 많이 쓰긴 한다
public class MyFactory<T, T2> {
	
	T material;
	T2 product;
	
	public void putMaterial(T material) {
		System.out.println("재료가 들어왔습니다 : " + material);
		this.material = material;
	}
	
	public T2 getProduct() {
		return product;
	}
	
}
