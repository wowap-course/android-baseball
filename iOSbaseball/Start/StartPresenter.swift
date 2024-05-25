//
//  StartPresenter.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/22/24.
//

import domain

class StartPresenter : StartViewPresenter{
    
    let view : StartView!
    var lifeCount: LifeCount! // 옵셔널 제거
    
    init(view: StartView) throws {
        self.view = view
        self.lifeCount = try LifeCount()
        
        view.showLife(lifeCount: lifeCount.lifes)
    }
    
    func increaseLifeCount() {
        if lifeCount.increase() { view.showLife(lifeCount: lifeCount.lifes) }
    }
    
    func decreaseLifeCount() {
        if lifeCount.decrease() { view.showLife(lifeCount: lifeCount.lifes) }
    }
    
    func startGame() {
        view.startGame(lifeCount: lifeCount.lifes)
    }
    
}
