package string;

import java.util.ArrayList;
import java.util.List;

import entity.Apple;

public class TestToString {

	public static void main(String[] args) {
		List<Apple> apples = new ArrayList<Apple>();
		for(int i = 0;i < 20;i ++) {
			apples.add(new Apple());
		}
		System.out.println(apples);
	}
}
