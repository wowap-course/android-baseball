//
//  StartPresenter.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/22/24.
//

import domain

import Foundation

class StartViewModel {
    private(set) var lifeCount: LifeCount
    private var lifeCountChangeNotification = Notification.Name("LifeCountChanged")
    
    init() throws {
        self.lifeCount = try LifeCount()
    }
    
    func increaseLifeCount() {
        if lifeCount.increase() {
            NotificationCenter.default.post(name: lifeCountChangeNotification, object: nil)
        }
    }
    
    func decreaseLifeCount() {
        if lifeCount.decrease() {
            NotificationCenter.default.post(name: lifeCountChangeNotification, object: nil)
        }
    }
    
    func getLifeCount() -> Int {
        return lifeCount.lifes
    }
    
    func startGame() {
        NotificationCenter.default.post(name: Notification.Name("StartGame"), object: lifeCount.lifes)
    }
}
