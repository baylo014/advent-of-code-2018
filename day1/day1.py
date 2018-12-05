from itertools import *
def part1():
    with open("day1.txt") as f:
        txt = f.readlines()
        num = list(map(lambda x:int(x),txt))
    print(sum(num))
    return num
def part2():
    num = part1()
    seen = {0}
    print(
        next(n for n in accumulate(cycle(num))
            if n in seen or seen.add(n)))
def format():
    with open("day1.txt") as f:
        txt = f.readlines()
        num = list(map(lambda x:int(x),txt))
    with open("input","w") as f:
        first = True
        for n in num:
            if first:
                if n >=0:
                    f.write("+"+str(n))
                else:
                    f.write(str(n))
                first = False
            else:
                if n >=0:
                    f.write(", +"+str(n))
                else:
                    f.write(", "+str(n))
def main():
    format()

if __name__ == '__main__':
    main()
