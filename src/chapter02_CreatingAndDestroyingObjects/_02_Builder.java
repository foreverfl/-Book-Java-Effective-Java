package chapter02_CreatingAndDestroyingObjects;

public class _02_Builder {

	@SuppressWarnings("unused")
	private final int servingSize;
	@SuppressWarnings("unused")
	private final int servings;
	@SuppressWarnings("unused")
	private final int calories;
	@SuppressWarnings("unused")
	private final int fat;
	@SuppressWarnings("unused")
	private final int sodium;
	@SuppressWarnings("unused")
	private final int carbohydrate;

	public static class Builder {
		// 필수 매개변수
		private final int servingSize;
		private final int servings;

		// 선택 매개변수
		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbohydrate = 0;

		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calories(int val) {
			calories = val;
			return this;
		}

		public Builder fat(int val) {
			fat = val;
			return this;
		}

		public Builder sodium(int val) {
			sodium = val;
			return this;
		}

		public Builder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}

		public _02_Builder build() {
			return new _02_Builder(this);
		}

	}

	private _02_Builder(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}

	public static void main(String[] args) {
		_02_Builder builder = new _02_Builder.Builder(1, 2).calories(100).fat(5).sodium(10).carbohydrate(20).build();
		System.out.println(builder);
	}

}
