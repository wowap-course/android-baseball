//
//  LifeCount.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/18/24.
//
enum LifeCountError: Error {
    case IllegalArgumentException
}

import Foundation

class LifeCount{
    private(set) var lifes : Int
    init(lifes: Int = 1) throws {
        self.lifes = lifes
        
        guard (MIN_LIFE_COUNT...MAX_LIFE_COUNT).contains(self.lifes) else {
             throw LifeCountError.IllegalArgumentException
        }
    }
    
    func increase() {
        if lifes < MAX_LIFE_COUNT {
            lifes += 1
        }
        
    }
    
    func decrease() {
        if lifes > MIN_LIFE_COUNT {
            lifes -= 1
        }
    }
    
    private let MIN_LIFE_COUNT = 1
    private let MAX_LIFE_COUNT = 9
}
