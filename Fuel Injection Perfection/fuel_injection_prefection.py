def solution(n):
    number = int(n)

    number_of_operation = 0

    while number != 1:
        if number & 1:
            if number & 2 and number != 3:
                number = number + 1
            else:
                number = number - 1
        else:
            number = number // 2
        number_of_operation = number_of_operation+1

    return number_of_operation

if __name__ == '__main__':
    print(solution("15"))
    print(solution("4"))

