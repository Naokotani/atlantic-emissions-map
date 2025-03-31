import hero from "../assets/images/hero.webp";
import arrow from "../assets/images/arrow.svg";

function Hero() {
  return (
    <div class="hero">
      <div class="hero__text">
        <h1 class="hero__heading">
          <span class="hero__heading--stroke">Atlantic</span> Industrial{" "}
          Emissions Map
        </h1>

        <div class="hero__intro">
          {<img class="hero__image--arrow" src={arrow} />}
          <div>
            <p class="hero__body">
              This map displays the latest annually reported greenhouse gas
              (GHG) emissions from large industrial facilities across Atlantic
              Canada.
            </p>
            <p class="hero__body">
              GHGs are displayed in metric tonnes in their CO
              <sub>2</sub> equivalent.
            </p>
          </div>
        </div>
      </div>

      <img
        class="hero__image--main"
        src={hero}
        alt="A billowing smoke stack in front of a low sun in a smoggy sky."
      />
    </div>
  );
}

export default Hero;
