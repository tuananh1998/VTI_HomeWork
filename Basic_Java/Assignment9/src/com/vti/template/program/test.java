
package com.vti.template.program;

import java.util.Scanner;

import com.vti.template.function.Function;
import com.vti.template.utils.Constant;
import com.vti.template.utils.ScannerUtil;

/**
 * This class is class test
 * 
 * @Description: .
 * @author: CTAnh
 * @create_date: Dec 18, 2019
 * @version: 1.0
 * @modifer: CTAnh
 * @modifer_date: Dec 18, 2019
 */

public class test {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean kt = false;
		int chucnang;

		do {
			System.out.println("Chao mung ban den voi chuong trinh cua chung toi!!! ");
			System.out.println("1. Them tai khoan");
			System.out.println("2. Sua tai khoan");
			System.out.println("3. Thoat");
			System.out.println("Hay chon chuc nang");
			chucnang = ScannerUtil.readInt(scanner, Constant.ERROR_VALIDATE_INT);
			switch (chucnang) {
			case 1: {
				Function.addUser();
				kt = true;
				break;
			}
			case 2: {
				Function.updateUser();
				kt = true;
				break;
			}
			default: {
				kt = false;
				break;
			}

			}

		} while (kt);

	}
}
