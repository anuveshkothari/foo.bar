def solution(area):
    result = list();

    while area > 0:
        biggest_side_possible = int(area ** .5)
        biggest_area = biggest_side_possible ** 2
        area -= biggest_area

        result.append(biggest_area)
    return  result

if __name__ == '__main__':
    print(solution(int(input())))