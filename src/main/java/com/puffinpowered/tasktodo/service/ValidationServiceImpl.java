package com.puffinpowered.tasktodo.service;

import com.puffinpowered.tasktodo.exception.Detail;
import com.puffinpowered.tasktodo.exception.ValidationError;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Stack;

@Service
public class ValidationServiceImpl implements ValidationService {


	public ValidationError buildValidationError(String input, String text) {
		Detail detail = new Detail();
		detail.setLocation("params");
		detail.setParam(text);
		detail.setMsg("Must be between 1 and 50 chars long");
		detail.setValue(input);
		ValidationError validationError = new ValidationError(detail, detail.getMsg());
		return validationError;
	}

	@Override
	public Boolean validate(String input) {
		Boolean result = Boolean.FALSE;

		if (StringUtils.hasLength(StringUtils.trimAllWhitespace(input)) && input.length() <= 50)  {
			result = Boolean.TRUE;
		}
		return result;	}

	//https://www.programcreek.com/2012/12/leetcode-valid-parentheses-java/
	@Override
	public Boolean checkBrackets(String input) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			char curr = input.charAt(i);
			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {  //this bit checks for balance
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.empty();
	}


}
