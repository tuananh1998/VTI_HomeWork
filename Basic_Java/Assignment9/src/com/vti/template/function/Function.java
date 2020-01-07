//

package com.vti.template.function;

import java.util.Scanner;

import com.vti.template.controller.UserController;
import com.vti.template.dto.Userdto;
import com.vti.template.utils.Constant;
import com.vti.template.utils.ScannerUtil;

/**
 * This class is Function in program.
 * 
 * @Description: .
 * @author: CTAnh
 * @create_date: Jan 7, 2020
 * @version: 1.0
 * @modifer: CTAnh
 * @modifer_date: Jan 7, 2020
 */

public class Function {
	/**
	 * This method is add User.
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Jan 7, 2020
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Jan 7, 2020
	 */
	public static void addUser() {
		String fName, lName, eMail;
		UserController controller = new UserController();
		Scanner scanner = new Scanner(System.in);
		// input firstname
		System.out.println("Hay nhap vao first name: ");
		fName = ScannerUtil.readString(scanner, Constant.ERROR_VALIDATE_STRING);

		// input lastname
		System.out.println("Hay nhap vao last name: ");
		lName = ScannerUtil.readString(scanner, Constant.ERROR_VALIDATE_STRING);

		// input email
		System.out.println("Hay nhap vao email: ");
		eMail = ScannerUtil.readString(scanner, Constant.ERROR_VALIDATE_STRING);

		// call method add
		if (controller.addUser(new Userdto(fName, lName, eMail))) {
			System.out.println("Create success!");
		} else {
			System.out.println("Create fail!");
		}

	}

	public static void updateUser() {
		String fName, lName, eMail;
		int luaChon;
		UserController controller = new UserController();
		Scanner scanner = new Scanner(System.in);
		// input email
		System.out.println("Hay nhap vao email: ");
		eMail = ScannerUtil.readString(scanner, Constant.ERROR_VALIDATE_STRING);

		// input firstname
		System.out.println("Hay nhap vao first name: ");
		fName = ScannerUtil.readString(scanner, Constant.ERROR_VALIDATE_STRING);

		// input lastname
		System.out.println("Hay nhap vao last name: ");
		lName = ScannerUtil.readString(scanner, Constant.ERROR_VALIDATE_STRING);

		// call method update
		if (controller.updateUser(new Userdto(fName, lName, eMail))) {
			System.out.println("update success!");
		} else {
			System.out.println("update fail!");
			System.out.println("Ban co muon them tai khoan nay khong?");
			System.out.println("1.Co");
			System.out.println("2.Khong");
			System.out.println("Chon: ");
			luaChon = ScannerUtil.readInt(scanner, Constant.ERROR_VALIDATE_INT);
			switch (luaChon) {
			case 1: {

				// call method add
				if (controller.addUser(new Userdto(fName, lName, eMail))) {
					System.out.println("Create success!");
				} else {
					System.out.println("Create fail!");
				}

				break;
			}

			default:
				break;
			}
		}

	}

}
