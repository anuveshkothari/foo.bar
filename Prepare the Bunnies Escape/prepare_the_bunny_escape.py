def solution(m):
    height, width = len(m), len(m[0])  # height & width of the map
    # print(height, width)

    min_path_global = 401  # initializing it to max value(20*20)

    for current_map in generate_all_maps(m, height, width):
        # print('map')
        # print(current_map)

        min_path_global = min(min_path_global, min_path_of_current_map(current_map, height, width))

        if min_path_global == height + width - 1:
            return min_path_global

    return min_path_global


def min_path_of_current_map(current_map, height, width):
    # initialize the dictionary with initial node, it contains the nodes for that path length(key)
    d = {1: {(0,0)}}
    current_path_length = 2
    while current_path_length < 401 and d[current_path_length - 1]:
        # all the list of nodes from start node to end node
        list_of_nodes_for_current_path_length = set()
        # print(d[1])
        for x in d[current_path_length - 1]:
            # print(x)
            new_neighbor = {neighbor for neighbor in neighbors(x, current_map) if
                            not any(neighbor in visited for visited in d.values())}

            # adding the non_visited nodes in the list of nodes
            list_of_nodes_for_current_path_length = list_of_nodes_for_current_path_length | new_neighbor

            #  if exit node is already added in the list of nodes(exit condition)
        if (height - 1, width - 1) in list_of_nodes_for_current_path_length:
            return current_path_length

        d[current_path_length] = list_of_nodes_for_current_path_length
        # print('dictionary')
        # print(d)
        current_path_length += 1

    return 401


def neighbors(node, m):
    # print(node)
    i, j = node
    width, height = len(m[0]), len(m)
    # possible neighbors
    candidates = {(i - 1, j),
                  (i + 1, j),
                  (i, j - 1),
                  (i, j + 1)}

    neighbor = set()

    for temp in candidates:
        x, y = temp
        if x >= 0 and x < height and y >= 0 and y < width and m[x][y] == 0:
            neighbor.add(temp)

    return neighbor


def generate_all_maps(initial_map, height, width):
    yield initial_map

    for i in range(height):
        for j in range(width):
            if initial_map[i][j]:
                copy_of_map = [[col for col in row] for row in initial_map]
                copy_of_map[i][j] = 0

                yield copy_of_map


print(solution([[0, 0, 0, 0, 0, 0],
                [1, 1, 1, 1, 1, 0],
                [0, 0, 0, 0, 0, 0],
                [0, 1, 1, 1, 1, 1],
                [0, 1, 1, 1, 1, 1],
                [0, 0, 0, 0, 0, 0]]))
