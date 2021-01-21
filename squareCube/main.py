''' Display square root and cube of numbers'''

def square():
    for i in range(1,5):
        print(f"Square : {i * i}")

def cube():
    for i in range(1,5):
        print(f"Cube {i*i*i}")


def main():
    square()
    cube()

main()