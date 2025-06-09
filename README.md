# Changes introduced

### 1. Introduction of `OrderStatus` Enumeration
- An `OrderStatus` enumeration has been added with values `NEW`, `PROCESSING`, `SHIPPED`, and `DELIVERED`. This enumeration is used in the `Order` class to represent the order's current status, improving the model's expressiveness and data integrity by restricting the status to predefined values.

### 2. Changes to the `Order` Class

- The `Order` class now includes the `OrderStatus` field, indicating the order's current state. This is a direct application of the newly introduced enumeration.
- A new `Map<Product, Integer>` field named `productQuantities` has been added. This field maps products to their quantities within an order, introducing a more detailed representation of order contents and allowing for complex operations like adjusting order quantities or analyzing order composition.

### 3. Composition between `Category` and `Products`

- The `@ManyToOne` association with `Category` has been adjusted to fetch type `LAZY`. This change is aimed at optimizing the loading behavior, reducing unnecessary data loading.
- A custom constructor has been introduced, aiming to enforce non-null `Category` association upon `Product` creation. 
- With the implementation of the cascade = CascadeType.ALL and orphanRemoval = true attributes in the @OneToMany relationship between Category and Product, this association corresponds to a composition.

### 4. Adjustments in the `Category` Class
- The `Category` class now uses a `Set<Product>` instead of a `List<Product>` for its `products` field. This change enforces uniqueness of `Product` instances within a `Category`, aligning with the set semantics that disallow duplicates, and addresses the proposal to ensure product uniqueness within categories.
