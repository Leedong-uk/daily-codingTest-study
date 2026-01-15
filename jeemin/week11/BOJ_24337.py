N, a, b = map(int, input().split())

buildings = []
for i in range(1, a):
    buildings.append(i)
buildings.append(max(a, b))
for i in range(b - 1, 0, -1):
    buildings.append(i)

if a != 1:
    for _ in range(len(buildings), N):
        buildings.insert(0, 1)
if a == 1:
    for _ in range(len(buildings), N):
        buildings.insert(a, 1)

if len(buildings) != N: print(-1)
else:
    ans = " ".join(map(str, buildings))
    print(ans)