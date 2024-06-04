//
//  ViewController.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/18/24.
//

import UIKit

class StartViewController: UIViewController {
    
    @IBOutlet weak var lifeLabel: UILabel!
    
    var viewModel: StartViewModel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        do {
            self.viewModel = try StartViewModel()
            self.updateLifeLabel()
            setupNotificationCenter()
        } catch {
            print("에러 발생: \(error)")
        }
    }
    
    private func setupNotificationCenter() {
        NotificationCenter.default.addObserver(self, selector: #selector(lifeCountChanged), name: Notification.Name("LifeCountChanged"), object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(startGame(notification:)), name: Notification.Name("StartGame"), object: nil)
    }
    
    @objc private func lifeCountChanged() {
        updateLifeLabel()
    }
    
    private func updateLifeLabel() {
        lifeLabel.text = String(viewModel.getLifeCount())
    }
    
    @objc private func startGame(notification: Notification) {
        if let lifeCount = notification.object as? Int {
            let storyboard = UIStoryboard(name: "MainView", bundle: nil)
            let vc = storyboard.instantiateViewController(withIdentifier: "MainViewController") as! MainViewController
            
            vc.lifeCount = lifeCount
            
            let navController = UINavigationController(rootViewController: vc)
            
            navController.modalPresentationStyle = .fullScreen
            present(navController, animated: true)
        }
    }
    
    @IBAction func btnMinus(_ sender: Any) {
        viewModel.decreaseLifeCount()
    }
    
    @IBAction func btnPlus(_ sender: Any) {
        viewModel.increaseLifeCount()
    }
    
    @IBAction func btnStart(_ sender: Any) {
        viewModel.startGame()
    }
    
    deinit {
        NotificationCenter.default.removeObserver(self)
    }
}
