package org.example.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailet {

	private Integer odId;
	private Integer orderId;
	private Integer foodId;
	private Integer quantity;
	private Food food;

}
