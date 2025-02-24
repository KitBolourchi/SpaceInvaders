package models

import Scene

sealed class SceneEntity {
    abstract fun update(scene: Scene)
}