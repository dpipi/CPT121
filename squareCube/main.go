package main

import "fmt"

func square() {
	for i := 1; i <= 5; i++ {
		fmt.Printf("square : %d ", i*i)
	}
}

func cube() {
	for i := 1; i <= 5; i++ {
		fmt.Printf("square : %d ", i*i*i)
	}
}

func main() {
	go square()
	go main()
}
